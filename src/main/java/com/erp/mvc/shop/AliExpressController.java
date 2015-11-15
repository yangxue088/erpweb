package com.erp.mvc.shop;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.erp.service.shop.AliExpressService;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/aliexpress")
public class AliExpressController {

	@Autowired
	private AliExpressService aliExpressService;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "auth")
	public @ResponseBody
	String auth(HttpServletRequest request, String shop) {
		String rooturl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		
		String redirect_uri = rooturl + "/aliexpress/token";
		String state = shop;
		
		String auth_url = aliExpressService.auth_url(redirect_uri, state);
		return auth_url;
	}

	@RequestMapping(value = "token")
	public ModelAndView token(String state, String code) {
		String shop = state;
		
		boolean result = aliExpressService.get_token(shop, code, true);
		
		ModelAndView modelAndView = new ModelAndView("/authresult");
		modelAndView.addObject("result", result);
		return modelAndView;
	}

}
