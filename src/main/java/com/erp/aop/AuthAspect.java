package com.erp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Aspect
@Component
public class AuthAspect {

	@Around("within(@org.springframework.stereotype.Controller *) && args(modelMap,..)")
	public Object doAround(ProceedingJoinPoint pjp, ModelMap modelMap)
			throws Throwable {
		if (modelMap.containsAttribute("userVo")) {
			return pjp.proceed();
		} else {
			System.out.println("没有登录，重定向到login");
			return "redirect:login";
		}
	}
}
