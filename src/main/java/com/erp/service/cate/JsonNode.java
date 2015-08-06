package com.erp.service.cate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonNode<T> {

	@JsonIgnore
	private T t;

	private Map<String, Object> m = new HashMap<String, Object>();

	private List<JsonNode<T>> data = new ArrayList<JsonNode<T>>();

	public JsonNode() {
		super();
	}

	public JsonNode(T t) {
		this.t = t;
	}

	public JsonNode(String... strs) {
		for (int i = 0; i + 1 < strs.length; i += 2) {
			setAttribute(strs[i], strs[i + 1]);
		}
	}

	public void setObject(T t) {
		this.t = t;
	}

	public void setAttribute(String name, Object value) {
		this.m.put(name, value);
	}

	public void addChild(JsonNode<T> child) {
		this.data.add(child);
	}

	@JsonAnyGetter
	public Map<String, Object> getM() {
		return m;
	}

	public void setM(Map<String, Object> m) {
		this.m = m;
	}

	public List<JsonNode<T>> getData() {
		return data;
	}

	public void setData(List<JsonNode<T>> data) {
		this.data = data;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
