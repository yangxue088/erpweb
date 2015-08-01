package com.erp.mvc.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userVo")
public class HomeController {

	@RequestMapping(value = "/home")
	public String home(ModelMap modelMap) {
		return "home";
	}
}