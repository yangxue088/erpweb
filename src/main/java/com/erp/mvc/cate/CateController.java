package com.erp.mvc.cate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.erp.bean.cate.Cate;
import com.erp.service.cate.CateService;
import com.erp.service.cate.JsonTree;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/cate")
public class CateController {

	@Autowired
	private CateService cateService;

	@RequestMapping
	public String cate(ModelMap modelMap) {
		return "cate1";
	}

	@RequestMapping(value = "/tree")
	public @ResponseBody
	JsonTree<Cate> tree(ModelMap modelMap) {
		return cateService.queryCates();
	}
}
