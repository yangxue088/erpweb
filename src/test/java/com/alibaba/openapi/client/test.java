package com.alibaba.openapi.client;

import com.alibaba.openapi.client.policy.ClientPolicy;

public class test {

	public static void main(String[] args) {
		
		// 使用自定义的client策略，包括使用域名gw.api.alibaba.com,端口默认为http 80，https 443
		ClientPolicy policy = new ClientPolicy("gw.api.alibaba.com");
		
		// 设置app的appKey以及对应的密钥，信息由注册app时生成
		policy = policy.setAppKey("2901405").setSigningKey("jVki3DaGtA");
		
		// 使用client策略来初始化AlibabaClient,建议保持单例
		AlibabaClient client = new AlibabaClient(policy);
	
		// 启动AlibabaClient实例
		client.start();
	}
}
