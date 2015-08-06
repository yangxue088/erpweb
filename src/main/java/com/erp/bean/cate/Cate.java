package com.erp.bean.cate;

public class Cate {

	private String name;
	private int depth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "Cate [name=" + name + ", depth=" + depth + "]";
	}

}
