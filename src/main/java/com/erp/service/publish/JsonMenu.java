package com.erp.service.publish;

import java.util.ArrayList;
import java.util.List;

public class JsonMenu {

	private int level = 1;
	private String menu = "";
	
	private List<JsonMenu> submenus = new ArrayList<JsonMenu>();

	public JsonMenu() {
	}

	public JsonMenu(String menu) {
		this.menu = menu;
	}

	public JsonMenu addSubMenu(String menu) {
		JsonMenu submenu = new JsonMenu(menu);
		submenu.level = this.level + 1;
		this.submenus.add(submenu);
		return submenu;
	}

	public void addSubMenus(String... menus) {
		for (String menu : menus) {
			addSubMenu(menu);
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

}
