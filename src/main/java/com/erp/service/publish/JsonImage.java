package com.erp.service.publish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonImage {

	@JsonProperty
	private List<String> initialPreview = new ArrayList<String>();

	@JsonProperty
	private List<Map<String, Object>> initialPreviewConfig = new ArrayList<Map<String, Object>>();

	@JsonProperty
	private boolean append = true;

	public void addInitialPreview(String imgsrc) {
		this.initialPreview.add(String.format(
				"<img src='%s' class='file-preview-image'>", imgsrc));
	}

	public void addInitialPreviewConfig(Object... initialPreviewConfig) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (initialPreviewConfig != null
				&& initialPreviewConfig.length % 2 == 0) {
			for (int i = 0; i + 1 < initialPreviewConfig.length; i += 2) {
				String key = String.valueOf(initialPreviewConfig[i]);
				Object value = initialPreviewConfig[i + 1];
				map.put(key, value);
			}
		}
		this.initialPreviewConfig.add(map);
	}

	public void addInitialPreviewConfig(Map<String, Object> initialPreviewConfig) {
		this.initialPreviewConfig.add(initialPreviewConfig);
	}

	public void setAppend(boolean append) {
		this.append = append;
	}

}
