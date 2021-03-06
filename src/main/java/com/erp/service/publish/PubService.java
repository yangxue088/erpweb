package com.erp.service.publish;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Service;

import com.erp.bean.category.Cate;
import com.erp.service.category.AbstCateService;
import com.erp.service.category.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PubService extends AbstCateService {

	private long lastModified = 0;
	private List<JsonMenu> menus = new ArrayList<JsonMenu>();

	public void readJson() {
		File file = new File("product.json");

		if (file.exists() && lastModified != file.lastModified()) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				this.menus = objectMapper.readValue(file,
						new TypeReference<List<JsonMenu>>() {
						});
				this.lastModified = file.lastModified();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<JsonMenu> nextMenus(int level, String name) {
		readJson();

		Queue<JsonMenu> queue = new LinkedList<JsonMenu>();
		for (JsonMenu menu : menus) {
			queue.offer(menu);

			while (!queue.isEmpty()) {
				JsonMenu m = queue.poll();
				if (m.getLevel() == level && m.getMenu().equals(name)) {
					return m.getSubmenus();
				} else {
					queue.addAll(m.getSubmenus());
				}
			}
		}
		return new ArrayList<JsonMenu>();
	}
	
	public String getPage(String type) {
		String[] menus = type.split(" > ");

		List<JsonMenu> nmenus = nextMenus(menus.length - 1,
				menus[menus.length - 2]);
		for (JsonMenu menu : nmenus) {
			if (menu.getMenu().equals(menus[menus.length - 1])) {
				return menu.getPage();
			}
		}

		return "";
	}

	@Override
	public JsonNode wrap(Cate cate) {
		JsonNode node = new JsonNode("data");
		if (cate != null) {
			node.setAttribute("groupid", cate.getId());
			node.setAttribute("group", cate.getName());
		}
		return node;
	}
}
