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
			node.setAttribute("id", cate.getId());
			node.setAttribute("category", cate.getName());
			node.setAttribute("createSubCategory", cate.getName());
			node.setAttribute("manageProduct", cate.getName());
			node.setAttribute("depth", cate.getDepth());
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
	
	public void exchange(String sid, String tid){
		Cate scate = cateDao.getCate(sid);
		Cate tcate = cateDao.getCate(tid);
		
		if(scate!=null && tcate!=null){
			int slft = scate.getLft();
			int srgt = scate.getRgt();
			
			scate.setLft(tcate.getLft());
			scate.setRgt(tcate.getRgt());
			
			tcate.setLft(slft);
			tcate.setRgt(srgt);
			
			cateDao.uptCate(scate.getId(), scate);
			cateDao.uptCate(tcate.getId(), tcate);
		}
	}
}
