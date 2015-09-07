package com.erp.service.publish;

import java.util.ArrayList;
import java.util.List;

public class JsonMenu {

	private int level = 1;
	private String menu = "";
	private String page = "";

	private List<JsonMenu> submenus = new ArrayList<JsonMenu>();

	public JsonMenu() {
	}

	public JsonMenu(String menu) {
		this.menu = menu;
	}

	public JsonMenu(String menu, String page) {
		this.menu = menu;
		this.page = page;
	}
	
	public JsonMenu addSubMenu(String menu) {
		JsonMenu submenu = new JsonMenu(menu);
		submenu.level = this.level + 1;
		this.submenus.add(submenu);
		return submenu;
	}

	public JsonMenu addSubMenu(String menu, String page) {
		JsonMenu submenu = new JsonMenu(menu, page);
		submenu.level = this.level + 1;
		this.submenus.add(submenu);
		return submenu;
	}

	public void addSubMenus(String... pairs) {
		for (int i = 0; i + 1 < pairs.length; i += 2) {
			String menu = pairs[i];
			String page = pairs[i + 1];
			addSubMenu(menu, page);
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public List<JsonMenu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<JsonMenu> submenus) {
		this.submenus = submenus;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
