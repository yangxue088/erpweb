package com.erp.service.category;

import org.springframework.stereotype.Service;

import com.erp.bean.category.Cate;

@Service
public class CateService extends AbstCateService {

	public JsonNode wrap(Cate cate) {
		JsonNode node = new JsonNode("data");
		if (cate != null) {
			node.setAttribute("cateid", cate.getId());
			node.setAttribute("category", cate.getName());
			node.setAttribute("manageProduct", cate.getName());
		}
		return node;
	}
}
