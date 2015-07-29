package com.erp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignController {

	@RequestMapping("/signin")
    public String signin(Model model) {
		System.out.println(model.asMap());
		return "index";
    }
}