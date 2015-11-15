package com.erp.oauth.aliexpress;

import java.text.SimpleDateFormat;

public class timeformat {

	public static void main(String[] args) throws Exception{
		String time = "20160123003527000-0800";
		
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSSZ").parse(time));
	}
}
