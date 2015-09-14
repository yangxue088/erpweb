package com.erp.mvc.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.erp.bean.category.Cate;
import com.erp.service.category.AbstCateService;
import com.erp.service.category.JsonNode;
import com.erp.service.category.JsonTree;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/cate")
public class CateController {

	@Autowired
	private AbstCateService cateService;

	@RequestMapping
	public String cate(ModelMap modelMap) {
		return "cate";
	}

	@RequestMapping(value = "/tree")
	public @ResponseBody
	JsonTree<Cate> tree(ModelMap modelMap) {
		return cateService.queryCates();
	}

	@RequestMapping(value = "/sort")
	public @ResponseBody
	void sort(@RequestParam String sname, @RequestParam String tname) {
		cateService.sort(sname, tname);
	}

	@RequestMapping(value = "/upt")
	public @ResponseBody
	void upt(@RequestParam String id, @RequestParam String name) {
		cateService.upt(id, name);
	}

	@RequestMapping(value = "/del")
	public @ResponseBody
	void del(@RequestParam String name) {
		cateService.del(name);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	JsonNode<Cate> add(@RequestParam String pname, @RequestParam String name,
			@RequestParam boolean child) {
		return cateService.add(pname, name, child);
	}
}
