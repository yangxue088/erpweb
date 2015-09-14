package com.erp.service.category;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

public class JsonTree<T> {

	private List<JsonNode<T>> roots = new ArrayList<JsonNode<T>>();

	public void addRoot(JsonNode<T> root) {
		this.roots.add(root);
	}

	@JsonValue
	public List<JsonNode<T>> getRoots() {
		return roots;
	}

	public void setRoots(List<JsonNode<T>> roots) {
		this.roots = roots;
	}

}
