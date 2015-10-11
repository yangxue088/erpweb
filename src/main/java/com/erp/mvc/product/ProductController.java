package com.erp.mvc.product;

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
import org.springframework.web.servlet.ModelAndView;

import com.erp.service.product.JsonTable;
import com.erp.service.product.ProductService;
import com.erp.service.publish.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping
	public String list(ModelMap modelMap) {
		return "product";
	}

	@RequestMapping(value = "/search")
	public @ResponseBody
	JsonTable search(@RequestParam String title, @RequestParam String code, @RequestParam String group, @RequestParam String inventory, @RequestParam int offset, @RequestParam int limit) {
		return productService.getProductTable(title, code, group, inventory, offset, limit);
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody
	String delete(@RequestParam List<String> ids) {
		return "success";
	}

	@RequestMapping(value = "/detail")
	public ModelAndView detail(ModelMap modelMap, @RequestParam int productid) {
		ModelAndView modelAndView = new ModelAndView("detail");
		modelAndView.addObject("productId", productid);
		return modelAndView;
	}

	@RequestMapping(value = "/getProduct")
	public @ResponseBody
	Product getProduct(@RequestParam int productId) {
		return productService.getProduct(productId);
	}

	private String picturepath = "/resources/tmp/picture/";

	@RequestMapping(value = "/getPictures")
	public @ResponseBody
	List<String> getPictures(@RequestParam int productId, HttpServletRequest request) {
		String rooturl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		List<String> imgsrcs = new ArrayList<String>();
		String filepath = servletContext.getRealPath(picturepath);
		List<String> pictures = productService.getPictures(productId, filepath);
		for (String picture : pictures) {
			imgsrcs.add(rooturl + picturepath + picture);
		}

		return imgsrcs;
	}

	@RequestMapping(value = "/getStocks")
	public @ResponseBody
	List<String[]> getStocks(@RequestParam int productId) {
		return productService.getStocks(productId);
	}

	@RequestMapping(value = "/setStocks")
	public @ResponseBody
	String setStocks(@RequestParam int productId, @RequestParam String stocks) {
		try {
			List<String> nstocks = new ObjectMapper().readValue(stocks, new TypeReference<List<String>>() {
			});
			List<String[]> sks = new ArrayList<String[]>();
			for (int i = 0; i < nstocks.size(); i += 4) {
				sks.add(new String[] { nstocks.get(i), nstocks.get(i + 1), nstocks.get(i + 2), nstocks.get(i + 3) });
			}
			productService.updateStocks(productId, sks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
