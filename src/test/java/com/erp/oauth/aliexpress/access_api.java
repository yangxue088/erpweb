package com.erp.oauth.aliexpress;


public class access_api {

	static String client_id = "2901405";
	static String client_secret = "jVki3DaGtA";
	
	static String api_version = "1";
	static String api_namespace = "aliexpress.open";
	static String api_name = "api.findOrderListQuery";
	
	
	public static void main(String[] args) {
		String access_token = "b7218129-c0a9-453e-840c-789cfdd07038";
		
		String url = String.format("http://gw.api.alibaba.com/openapi/param2/%s/%s/%s/%s", api_version, api_namespace, api_name, client_id);
		
		access();
	}
	
	

	public static void access() {
		String url = String.format("https://gw.api.alibaba.com/openapi/http/1/system.oauth2/getToken/%s", client_id);

		
	}


}
