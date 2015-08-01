package com.erp.mvc.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.erp.service.authority.UserService;
import com.erp.service.authority.UserVo;

@Controller
@SessionAttributes("userVo")
public class SignController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(@RequestParam String username,
			@RequestParam String password, ModelMap modelMap) {
		if (!modelMap.containsAttribute("userVo")) {
			UserVo userVo = userService.queryUserVo(username, password);
			if (userVo != null) {
				modelMap.addAttribute("userVo", userVo);
				System.out.println("登录成功,用户信息:" + userVo);
				return "redirect:home";
			} else {
				modelMap.addAttribute("error", "用户名或密码错误");
				System.out.println("登录失败,用户名或密码错误");
				return "redirect:login";
			}
		} else {
			System.out.println("已登录,用户信息:" + modelMap.get("userVo"));
			return "redirect:home";
		}
	}

	@RequestMapping(value = "/signout")
	public String signout(ModelMap modelMap, SessionStatus sessionStatus) {
		System.out.println("注销用户:" + modelMap.get("userVo"));
		sessionStatus.setComplete();
		return "redirect:login";
	}
}