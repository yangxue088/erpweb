package com.erp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class AuthAspect {

	@Around("within(@org.springframework.stereotype.Controller *)  && args(modelMap,..)")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint,
			ModelMap modelMap) throws Throwable {
		if (modelMap.containsAttribute("userVo")) {
			return proceedingJoinPoint.proceed();
		} else {
			System.out.println("没有登录，重定向到login");

			Signature signature = proceedingJoinPoint.getSignature();
			Class<?> returnType = ((MethodSignature) signature).getReturnType();
			if (returnType == String.class) {
				return "redirect:/login";
			} else if (returnType == ModelAndView.class) {
				return new ModelAndView("redirect:/login");
			} else {
				throw new AssertionError("切面的返回值的类型错误");
			}
		}
	}

}
