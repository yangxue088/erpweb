package com.erp.service.cate;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.bean.cate.Cate;
import com.erp.dao.cate.CateDao;

@Service
public class CateService {

	@Autowired
	private CateDao cateDao;

	public JsonTree<Cate> queryCates() {
		JsonTree<Cate> jsonTree = new JsonTree<Cate>();

		List<Cate> cates = cateDao.getCates();

		Stack<JsonNode<Cate>> stack = new Stack<JsonNode<Cate>>();

		Collections.reverse(cates);
		for (Cate cate : cates) {
			JsonNode<Cate> node = new JsonNode<Cate>(cate);
			node.setAttribute("value", cate.getName());
			node.setAttribute("open", true);
			while (!stack.isEmpty()
					&& cate.getDepth() < stack.peek().getT().getDepth()) {
				node.addChild(stack.pop());
			}
			stack.push(node);
		}

		while (!stack.isEmpty()) {
			jsonTree.addRoot(stack.pop());
		}

		return jsonTree;
	}
}
