package com.erp.service.publish;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.bean.cate.Cate;
import com.erp.dao.cate.publish.PublishDao;
import com.erp.service.cate.AbstCateService;
import com.erp.service.cate.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PubService extends AbstCateService {

	private long lastModified = 0;
	private List<JsonMenu> menus = new ArrayList<JsonMenu>();

	@Autowired
	private PublishDao publishDao;

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

	@Override
	public JsonNode<Cate> wrap(Cate cate) {
		JsonNode<Cate> node = new JsonNode<Cate>(cate);
		if (cate != null) {
			node.setAttribute("groupid", cate.getId());
			node.setAttribute("group", cate.getName());
		}
		return node;
	}

	public int savepic(String filename, InputStream is) {
		return publishDao.savepic(filename, is);
	}

	public void saveproduct(Product product, List<Integer> picids) {
		
	}
}
