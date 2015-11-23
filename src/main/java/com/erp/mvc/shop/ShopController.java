package com.erp.mvc.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.erp.service.shop.Shop;
import com.erp.service.shop.ShopService;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping
	public String shop(ModelMap modelMap) {
		return "shop";
	}

	@RequestMapping(value = "list")
	public @ResponseBody
	List<Shop> list(ModelMap modelMap) {
		return shopService.listShop();
	}

	@RequestMapping(value = "edit")
	public @ResponseBody
	String edit(ModelMap modelMap, String id, String name) {
		shopService.editShop(id, name);
		return "success";
	}

	@RequestMapping(value = "delete")
	public @ResponseBody
	String delete(ModelMap modelMap, String id) {
		shopService.deleteShop(id);
		return "success";
	}
}
