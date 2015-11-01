package com.erp.service.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonNode {

	@JsonIgnore
	private String childkey = "data";

	private Map<String, Object> m = new HashMap<String, Object>();

	public JsonNode() {
		super();
	}

	public JsonNode(String childkey) {
		super();
		this.childkey = childkey;
	}

	public JsonNode(String... strs) {
		for (int i = 0; i + 1 < strs.length; i += 2) {
			setAttribute(strs[i], strs[i + 1]);
		}
	}

	public void setAttribute(String name, Object value) {
		this.m.put(name, value);
	}

	@JsonAnyGetter
	public Map<String, Object> getM() {
		return m;
	}

	public void setM(Map<String, Object> m) {
		this.m = m;
	}

	public String getChildkey() {
		return childkey;
	}

	public void setChildkey(String childkey) {
		this.childkey = childkey;
	}

	@SuppressWarnings("unchecked")
	public void addChild(JsonNode node) {
		if (!m.containsKey(node.childkey)) {
			m.put(node.childkey, new ArrayList<JsonNode>());
		}
		Object obj = m.get(node.childkey);
		List<JsonNode> children = (List<JsonNode>) obj;
		children.add(node);
	}

}
