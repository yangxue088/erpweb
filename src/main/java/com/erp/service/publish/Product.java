package com.erp.service.publish;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String type;

	private String title;

	private int gid;

	private List<String> pictures = new ArrayList<String>();

	private String json;

	private List<String[]> stocks = new ArrayList<String[]>();

	@Override
	public String toString() {
		return "Product [type=" + type + ", title=" + title + ", gid=" + gid
				+ ", pictures=" + pictures + ", json=" + json + ", stocks="
				+ stocks + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<String[]> getStocks() {
		return stocks;
	}

	public void setStocks(List<String[]> stocks) {
		this.stocks = stocks;
	}


}
