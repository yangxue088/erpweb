package com.erp.mvc.publish;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.erp.service.publish.PubService;
import com.erp.util.FileUtil;

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
			jsonLi.setHasSon(menu.getSubmenus().size() > 0);
			lis.add(jsonLi);
		}

		return lis;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView edit(ModelMap modelMap, @RequestParam String text) {
		ModelAndView modelAndView = new ModelAndView(
				"decorators/publish-edit/category/phone");
		modelAndView.addObject("choosetext", text);
		return modelAndView;
	}

	@RequestMapping(value = "/select")
	public @ResponseBody
	JsonTree<Cate> select() {
		return pubService.queryCates();
	}

	@RequestMapping(value = "/image/upload")
	public @ResponseBody
	JsonImage image_upload(@RequestParam MultipartFile[] images,
			HttpServletRequest request) {

		JsonImage jsonImage = new JsonImage();

		String relativepath = "/resources/tmp/upload/";

		String rooturl = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();

		String tmpdir = servletContext.getRealPath(relativepath);

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

}
