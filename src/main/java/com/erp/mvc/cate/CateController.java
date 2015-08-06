package com.erp.mvc.cate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userVo")
public class CateController {

	@RequestMapping(value = "/cate")
	public String home(ModelMap modelMap) {
		return "cate1";
	}
}
