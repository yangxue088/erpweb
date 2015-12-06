package com.erp.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static <T> T readJson(String json, Class<T> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> String toJson(List<T> list) {
		try {
			return new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static <K, V> String toJson(Map<K, V> map) {
		try {
			return new ObjectMapper().writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
