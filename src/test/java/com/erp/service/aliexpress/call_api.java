package com.erp.service.aliexpress;

public class call_api {

	public static void main(String[] args) {
		AliExpressService aliExpressService = new AliExpressService();
		aliExpressService.call_api("a961d5f9-cd50-4173-ade7-576bbc41a301", "api.findOrderListQuery", "page", 1, "pageSize", 20);
	}
}
