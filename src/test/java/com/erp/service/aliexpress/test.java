package com.erp.service.aliexpress;

public class test {

	public static void main(String[] args) {
		AliClient aliClient = new AliClient();

		// System.out.println(aliClient.getAuthUrl("localhost:8080", "xxx"));

		 System.out.println(aliClient.getToken("57c8ab4f-5aa6-4ec8-84ba-bs5fe70fc8182"));

//		 System.out.println(aliClient.refreshToken("e46b079c-0c5d-4507-afdd-eeb63cb672d9"));

//		System.out.println(aliClient.invokeApi("73a2818sd-ba72-4521-bc66-2585fbce7612", "api.findOrderListQuery", "page", "1", "pageSize", "5"));
	}
}
