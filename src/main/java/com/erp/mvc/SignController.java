package com.erp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignController {

	@RequestMapping("/signin")
	public String signin(@RequestParam String username,
			@RequestParam String password) {
		System.out.println(username + " " + password);
		return "index";
	}
}