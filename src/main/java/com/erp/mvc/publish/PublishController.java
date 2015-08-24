package com.erp.mvc.publish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.erp.service.publish.JsonLi;
import com.erp.service.publish.JsonMenu;
import com.erp.service.publish.PubService;

@Controller
@SessionAttributes("userVo")
@RequestMapping(value = "/publish")
public class PublishController {

	@Autowired
	private PubService pubService;

	@RequestMapping
	public String publish(ModelMap modelMap) {
		return "publish";
	}

	@RequestMapping(value = "/list")
	public @ResponseBody
	List<JsonLi> list(@RequestParam int level, @RequestParam String name) {
		List<JsonLi> lis = new ArrayList<JsonLi>();

		for (JsonMenu menu : pubService.nextMenus(level, name)) {
			JsonLi jsonLi = new JsonLi();
			jsonLi.setName(menu.getMenu());
			jsonLi.setHasSon(menu.getSubmenus().size() > 0);
			lis.add(jsonLi);
		}

		return lis;
	}

	@RequestMapping(value = "/edit")
	public ModelAndView edit(ModelMap modelMap, @RequestParam String text) {
		ModelAndView modelAndView = new ModelAndView("publish-edit");
		modelAndView.addObject("choosetext", text);
		return modelAndView;
	}

}
