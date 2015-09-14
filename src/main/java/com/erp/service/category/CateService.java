package com.erp.service.category;

import org.springframework.stereotype.Service;

import com.erp.bean.category.Cate;

@Service
public class CateService extends AbstCateService {

	public JsonNode<Cate> wrap(Cate cate) {
		JsonNode<Cate> node = new JsonNode<Cate>(cate);
		if (cate != null) {
			node.setAttribute("cateid", cate.getId());
			node.setAttribute("category", cate.getName());
			node.setAttribute("manageProduct", cate.getName());
		}
		return node;
	}
}
