package com.erp.mvc.authority;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.erp.service.authority.UserVo;

@Controller
@SessionAttributes("userVo")
public class SignController {

	@RequestMapping("/signin")
	public String signin(@RequestParam String username,
			@RequestParam String password, ModelMap modelMap) {

		if (!modelMap.containsAttribute("userVo")) {
			UserVo userVo = new UserVo();
			userVo.setUsername(username);
			userVo.setPassword(password);
			userVo.setLoginTime(new Date());

			modelMap.addAttribute("userVo", userVo);
			System.out.println("现在登录,用户信息:" + userVo);
		} else {
			System.out.println("已登录,用户信息:" + modelMap.get("userVo"));
		}

		return "redirect:home";
	}

	@RequestMapping("/signout")
	public String signout(@ModelAttribute("userVo") UserVo userVo,
			SessionStatus sessionStatus) {
		System.out.println("注销用户:" + userVo);
		sessionStatus.setComplete();
		return "redirect:login";
	}
}