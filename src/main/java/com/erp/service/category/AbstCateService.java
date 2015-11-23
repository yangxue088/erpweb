package com.erp.service.category;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;

import com.erp.bean.category.Cate;
import com.erp.dao.category.CateDao;

public abstract class AbstCateService {

	@Autowired
	private CateDao cateDao;

	public  JsonTree queryCates() {
		JsonTree jsonTree = new JsonTree();

		Map<Cate, JsonNode> map = new HashMap<Cate, JsonNode>();
		Stack<Cate> stack = new Stack<Cate>();
		
		List<Cate> cates = cateDao.getCates();
		Collections.reverse(cates);
		for (Cate cate : cates) {
			JsonNode node = wrap(cate);
			map.put(cate, node);
			
			while (!stack.isEmpty()
					&& cate.getDepth() < stack.peek().getDepth()) {
				node.addChild(map.get(stack.pop()));
			}
			stack.push(cate);
		}

		while (!stack.isEmpty()) {
			jsonTree.addRoot(map.get(stack.pop()));
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

	public JsonNode add(String pname, String name, boolean child) {
		return wrap(cateDao.addCate(pname, name, child));
	}

	public abstract JsonNode wrap(Cate cate);

}