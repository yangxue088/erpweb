package com.erp.mvc.publish;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.erp.bean.cate.Cate;
import com.erp.service.cate.JsonTree;
import com.erp.service.publish.JsonImage;
import com.erp.service.publish.JsonLi;
import com.erp.service.publish.JsonMenu;
import com.erp.service.publish.Product;
import com.erp.service.publish.PubService;
import com.erp.util.FileUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/publish")
public class PublishController {

	@Autowired
	private PubService pubService;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping
	public String publish(ModelMap modelMap) {
		return "publish";
	}

	@RequestMapping(value = "/list")
	public @ResponseBody
	List<JsonLi> list(@RequestParam int level, @RequestParam String name) {
		List<JsonLi> lis = new ArrayList<JsonLi>();

		for (JsonMenu menu : pubService.nextMenus(level, name)) {
			JsonLi jsonLi = new JsonLi();
			jsonLi.setName(menu.getMenu());
			jsonLi.setPage(menu.getPage());
			jsonLi.setHasSon(menu.getSubmenus().size() > 0);
			lis.add(jsonLi);
		}

		return lis;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView edit(ModelMap modelMap, @RequestParam String text,
			@RequestParam String page) {
		ModelAndView modelAndView = new ModelAndView(
				"decorators/publish-edit/category/" + page);
		modelAndView.addObject("choosetext", text);
		return modelAndView;
	}

	@RequestMapping(value = "/select")
	public @ResponseBody
	JsonTree<Cate> select() {
		return pubService.queryCates();
	}

	private String relativepath = "/resources/tmp/upload/";

	private String tmpdir = servletContext.getRealPath(relativepath);

	@RequestMapping(value = "/image/upload")
	public @ResponseBody
	JsonImage image_upload(@RequestParam MultipartFile[] images,
			HttpServletRequest request) {

		JsonImage jsonImage = new JsonImage();

		String rooturl = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();

		for (MultipartFile image : images) {

			String filename = image.getOriginalFilename();

			String filepath = tmpdir + File.separator + filename;

			File file = FileUtil.createNewFile(filepath, true);

			try {
				image.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String imgsrc = rooturl + relativepath + filename;

			jsonImage.addInitialPreview(imgsrc);

			jsonImage.setAppend(false);
		}

		return jsonImage;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Product.class, new PropertyEditorSupport() {

			public void setAsText(String text) throws IllegalArgumentException {
				ObjectMapper mapper = new ObjectMapper();
				try {
					Product product = mapper.readValue(text, Product.class);
					this.setValue(product);
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
	}

	@RequestMapping(value = "/submit")
	public @ResponseBody
	String submit(@RequestParam Product product) {
		List<Integer> picids = new ArrayList<Integer>();
		
		List<String> pics = product.getPictures();
		for (String pic : pics) {
			try {
				String filename = pic;
				FileInputStream is = new FileInputStream(tmpdir
						+ File.separator + filename);
				picids.add(pubService.savepic(filename, is));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		pubService.saveproduct(product, picids);
		
		return "success";
	}

}
