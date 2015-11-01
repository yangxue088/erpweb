//package com.erp.service.category;
//
//import com.erp.bean.category.Cate;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class test {
//
//	public static void main(String[] args) throws Exception {
//		JsonTree<Cate> tree = new JsonTree<Cate>();
//
//		JsonNode<Cate> root = new JsonNode<Cate>();
//		Cate c1 = new Cate();
//		c1.setName("1");
//
//		root.setObject(c1);
//		root.setAttribute("editor", "text");
//		root.setAttribute("value", "1");
//
//		JsonNode<Cate> child = new JsonNode<Cate>();
//		Cate c2 = new Cate();
//		c2.setName("2");
//
//		child.setObject(c2);
//		child.setAttribute("editor", "txxext");
//		root.setAttribute("value", "2");
//
//		root.addChild(child);
//		tree.addRoot(root);
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		System.out.println(mapper.writeValueAsString(tree));
//	}
//}
