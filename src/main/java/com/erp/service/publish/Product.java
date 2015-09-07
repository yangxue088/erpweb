package com.erp.service.publish;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Product {

	private String type = "";

	private Map<String, String> attrs = new LinkedHashMap<String, String>();

	private Map<String, String> cattrs = new LinkedHashMap<String, String>();

	private String title = "";

	private String keyword = "";

	private String morekeyword1 = "";

	private String morekeyword2 = "";

	private String measureunit = "";

	private String saletype = "";

	private String numofpackage = "";

	private List<String> pictures = new ArrayList<String>();

	private Map<String, String> salestyles = new LinkedHashMap<String, String>();

	private Map<String, String> colors = new LinkedHashMap<String, String>();

	private List<List<String>> inventories = new ArrayList<List<String>>();

	private String inventory = "";

	private String code = "";

	private String weight = "";

	private List<String> customweight = new ArrayList<String>();

	private List<String> packagesize = new ArrayList<String>();

	private String groupid = "";

	@Override
	public String toString() {
		return "Product [type=" + type + ", attrs=" + attrs + ", cattrs="
				+ cattrs + ", title=" + title + ", keyword=" + keyword
				+ ", morekeyword1=" + morekeyword1 + ", morekeyword2="
				+ morekeyword2 + ", measureunit=" + measureunit + ", saletype="
				+ saletype + ", numofpackage=" + numofpackage + ", pictures="
				+ pictures + ", salestyles=" + salestyles + ", colors="
				+ colors + ", inventories=" + inventories + ", inventory="
				+ inventory + ", code=" + code + ", weight=" + weight
				+ ", customweight=" + customweight + ", packagesize="
				+ packagesize + ", groupid=" + groupid + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getAttrs() {
		return attrs;
	}

	public void setAttrs(Map<String, String> attrs) {
		this.attrs = attrs;
	}

	public Map<String, String> getCattrs() {
		return cattrs;
	}

	public void setCattrs(Map<String, String> cattrs) {
		this.cattrs = cattrs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMorekeyword1() {
		return morekeyword1;
	}

	public void setMorekeyword1(String morekeyword1) {
		this.morekeyword1 = morekeyword1;
	}

	public String getMorekeyword2() {
		return morekeyword2;
	}

	public void setMorekeyword2(String morekeyword2) {
		this.morekeyword2 = morekeyword2;
	}

	public String getMeasureunit() {
		return measureunit;
	}

	public void setMeasureunit(String measureunit) {
		this.measureunit = measureunit;
	}

	public String getSaletype() {
		return saletype;
	}

	public void setSaletype(String saletype) {
		this.saletype = saletype;
	}

	public String getNumofpackage() {
		return numofpackage;
	}

	public void setNumofpackage(String numofpackage) {
		this.numofpackage = numofpackage;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}

	public Map<String, String> getSalestyles() {
		return salestyles;
	}

	public void setSalestyles(Map<String, String> salestyles) {
		this.salestyles = salestyles;
	}

	public Map<String, String> getColors() {
		return colors;
	}

	public void setColors(Map<String, String> colors) {
		this.colors = colors;
	}

	public List<List<String>> getInventories() {
		return inventories;
	}

	public void setInventories(List<List<String>> inventories) {
		this.inventories = inventories;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<String> getCustomweight() {
		return customweight;
	}

	public void setCustomweight(List<String> customweight) {
		this.customweight = customweight;
	}

	public List<String> getPackagesize() {
		return packagesize;
	}

	public void setPackagesize(List<String> packagesize) {
		this.packagesize = packagesize;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

}
