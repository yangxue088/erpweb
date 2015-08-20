package com.erp.service.publish.json.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.erp.service.publish.JsonMenu;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonGenerator {

	public static void main(String[] args) throws Exception {
		List<JsonMenu> menus = createMenus();

		System.out.println("产品配置文件生成在:" + writeJson(menus));
	}

	private static List<JsonMenu> createMenus() {
		List<JsonMenu> menus = new ArrayList<JsonMenu>();

		JsonMenu menu1 = new JsonMenu("电话和通讯");
		menu1.addSubMenu("手机配件和零件").addSubMenus("移动电源", "手机耳机", "手机机壳");
		menu1.addSubMenu("手机");

		JsonMenu menu2 = new JsonMenu("旅游及度假");
		menu2.addSubMenu("交通卡劵");
		menu2.addSubMenu("旅游相关商品").addSubMenus("地图", "明信片", "代客烧香/还愿", "旅游攻略");

		menus.add(menu1);
		menus.add(menu2);

		return menus;
	}

	private static String writeJson(List<JsonMenu> menus) throws Exception {
		File file = new File("product.json");

		if (file.exists()) {
			FileUtils.forceDelete(file);
		}

		if (file.createNewFile()) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			objectMapper.writeValue(new FileOutputStream(file), menus);
		}

		return file.getAbsolutePath();
	}
}
