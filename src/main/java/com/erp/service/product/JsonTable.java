package com.erp.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonTable {
	
	private int total = 0;
	
	private List<Map<String,String>> rows = new ArrayList<Map<String,String>>();
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Map<String, String>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, String>> rows) {
		this.rows = rows;
	}

	
}
