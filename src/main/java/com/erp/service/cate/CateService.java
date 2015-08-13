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

	private JsonNode<Cate> wrap(Cate cate) {
		JsonNode<Cate> node = new JsonNode<Cate>(cate);
		if (cate != null) {
			node.setAttribute("cateid", cate.getId());
			node.setAttribute("category", cate.getName());
			node.setAttribute("manageProduct", cate.getName());
		}
		return node;
	}

	public JsonTree<Cate> queryCates() {
		JsonTree<Cate> jsonTree = new JsonTree<Cate>();

		List<Cate> cates = cateDao.getCates();

		Stack<JsonNode<Cate>> stack = new Stack<JsonNode<Cate>>();

		Collections.reverse(cates);
		for (Cate cate : cates) {
			JsonNode<Cate> node = wrap(cate);
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

	public void sort(String sname, String tname) {
		cateDao.sort(sname, tname);
	}

	public void upt(String id, String name) {
		Cate cate = new Cate();
		cate.setName(name);
		cateDao.uptCate(id, cate);
	}

	public void del(String name) {
		cateDao.delCate(name);
	}

	public JsonNode<Cate> add(String pname, String name, boolean child) {
		return wrap(cateDao.addCate(pname, name, child));
	}
}
