package com.erp.mvc.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.erp.service.order.OrderService;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping
	public String order(ModelMap modelMap) {
		return "order";
	}
	
	@RequestMapping(value="sync")
	public @ResponseBody String sync() {
		orderService.sync();
		return "success";
	}
	
	

}
