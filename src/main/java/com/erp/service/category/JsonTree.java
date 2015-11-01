package com.erp.service.category;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

public class JsonTree {

	private List<JsonNode> roots = new ArrayList<JsonNode>();

	public void addRoot(JsonNode root) {
		this.roots.add(root);
	}

	@JsonValue
	public List<JsonNode> getRoots() {
		return roots;
	}

	public void setRoots(List<JsonNode> roots) {
		this.roots = roots;
	}

}
