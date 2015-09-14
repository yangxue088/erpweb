package com.erp.mvc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.erp.service.product.ProductService;
import com.erp.service.publish.Product;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/detail")
	public ModelAndView detail(ModelMap modelMap, @RequestParam int productid) {
		ModelAndView modelAndView = new ModelAndView("detail");
		modelAndView.addObject("productId", productid);
		return modelAndView;
	}

	@RequestMapping(value = "/get")
	public @ResponseBody
	Product getProduct(@RequestParam int productId) {
		return productService.getProduct(productId);
	}
}
