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

import com.erp.bean.category.Cate;
import com.erp.service.category.JsonTree;
import com.erp.service.product.ProductService;
import com.erp.service.publish.JsonLi;
import com.erp.service.publish.JsonMenu;
import com.erp.service.publish.Product;
import com.erp.service.publish.PubService;
import com.erp.util.FileUtil;
import com.erp.util.JSONUtil;
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
	private ProductService productService;

	@Autowired
	private ServletContext servletContext;

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
	public ModelAndView edit(ModelMap modelMap, @RequestParam String text, @RequestParam String page) {
		ModelAndView modelAndView = new ModelAndView("decorators/publish-edit/category/" + page);
		modelAndView.addObject("choosetext", text);
		return modelAndView;
	}

	@RequestMapping(value = "/select")
	public @ResponseBody
	JsonTree<Cate> select() {
		return pubService.queryCates();
	}

	private String uploadpath = "/resources/tmp/upload/";

	@RequestMapping(value = "/image/upload")
	public @ResponseBody
	List<String> image_upload(@RequestParam MultipartFile[] images, HttpServletRequest request) {
		List<String> uploadFiles = new ArrayList<String>();
		for (MultipartFile image : images) {
			String filename = FileUtil.genUUID() + ".jpg";

			String filepath = servletContext.getRealPath(uploadpath) + File.separator + filename;
			File file = FileUtil.createNewFile(filepath, true);

			try {
				image.transferTo(file);
				uploadFiles.add(filename);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return uploadFiles;
	}

	@RequestMapping(value = "/image/delete")
	public @ResponseBody
	String image_delete(@RequestParam("key") int pictureId) {
		productService.deletePicture(pictureId);
		return "";
	}

	@RequestMapping(value = "/submit")
	public @ResponseBody
	String submit(@RequestParam(required = false) Integer productId, @RequestParam Product product) {
		// means create product
		if (productId == null) {
			productId = productService.createProduct(product);
		}
		// means update product
		else {
			productService.updateProduct(productId, product);
		}

		for (String picture : product.getPictures()) {
			try {
				FileInputStream is = new FileInputStream(servletContext.getRealPath(uploadpath) + File.separator + picture);
				productService.createPicture(picture, is, productId);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return "success";
	}

	private String picturepath = "/resources/tmp/picture/";

	@RequestMapping(value = "/reedit")
	public ModelAndView reedit(ModelMap modelMap, HttpServletRequest request, @RequestParam int productid) {

		Product product = productService.getProduct(productid);

		List<String[]> stocks = productService.getStocks(productid);

		String page = pubService.getPage(product.getType());

		String rooturl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		List<String> imgids = new ArrayList<String>();
		List<String> imgsrcs = new ArrayList<String>();
		String filepath = servletContext.getRealPath(picturepath);
		List<String> pictures = productService.getPictures(productid, filepath);
		for (String picture : pictures) {
			imgids.add(picture.substring(0, picture.indexOf(".")));
			imgsrcs.add(rooturl + picturepath + picture);
		}

		ModelAndView modelAndView = new ModelAndView("decorators/publish-edit/category/" + page);

		modelAndView.addObject("choosetext", product.getType());

		modelAndView.addObject("productId", productid);
		modelAndView.addObject("product", product.getJson());
		modelAndView.addObject("imgids", JSONUtil.tojson(imgids));
		modelAndView.addObject("imgsrcs", JSONUtil.tojson(imgsrcs));
		modelAndView.addObject("stocks", JSONUtil.tojson(stocks));

		return modelAndView;
	}

}
