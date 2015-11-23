package com.erp.service.aliexpress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class get_token {

	static String client_id = "2901405";
	static String client_secret = "jVki3DaGtA";
	static String redirect_uri = "http://localhost:8080";
	static String state = "test_state";

	public static void main(String[] args) {
		auth_request();
	}

	public static void auth_request() {
		String code = "67028447-7156-40ae-a41a-53bc10dbe58d";

		String url = String.format("https://gw.api.alibaba.com/openapi/http/1/system.oauth2/getToken/%s", client_id);

		System.out.println(url);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
		nvps.add(new BasicNameValuePair("need_refresh_token", "true"));
		nvps.add(new BasicNameValuePair("client_id", client_id));
		nvps.add(new BasicNameValuePair("client_secret", client_secret));
		nvps.add(new BasicNameValuePair("redirect_uri", redirect_uri));
		nvps.add(new BasicNameValuePair("code", code));
		
		System.out.println(nvps);

		gettoken(url, nvps);
	}

	public static void gettoken(String url, List<NameValuePair> nvps) {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response2 = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			response2 = httpClient.execute(httpPost);

			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			String data = EntityUtils.toString(entity2);
		
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
