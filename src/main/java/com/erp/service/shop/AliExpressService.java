package com.erp.service.shop;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.shop.ShopDao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AliExpressService {

	private String aliexpress_client_id = "2901405";

	private String aliexpress_client_secret = "jVki3DaGtA";

	@Autowired
	private ShopDao shopDao;

	public String auth_url(String redirect_uri, String state) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		map.put("client_id", aliexpress_client_id);
		map.put("site", "aliexpress");
		map.put("redirect_uri", redirect_uri);
		map.put("state", state);

		String data = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			data += entry.getKey() + entry.getValue();
		}

		String _aop_signature = auth_signature(data, aliexpress_client_secret);

		String url = String.format("http://authhz.alibaba.com/auth/authorize.htm?client_id=%s&site=aliexpress&redirect_uri=%s&state=%s&_aop_signature=%s", aliexpress_client_id, redirect_uri, state, _aop_signature);
		return url;
	}

	public boolean get_token(String shop, String code, Boolean need_refresh_token) {
		String url = String.format("https://gw.api.alibaba.com/openapi/http/1/system.oauth2/getToken/%s", aliexpress_client_id);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
		nvps.add(new BasicNameValuePair("need_refresh_token", need_refresh_token.toString()));
		nvps.add(new BasicNameValuePair("client_id", aliexpress_client_id));
		nvps.add(new BasicNameValuePair("client_secret", aliexpress_client_secret));
		nvps.add(new BasicNameValuePair("redirect_uri", "test"));
		nvps.add(new BasicNameValuePair("code", code));

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);

			Map<String, String> map = new ObjectMapper().readValue(json.getBytes(), new TypeReference<Map<String, String>>() {
			});

			String resource_owner = map.get("resource_owner");
			String access_token = map.get("access_token");
			String refresh_token = map.get("refresh_token");
			String refresh_token_timeout = map.get("refresh_token_timeout");

			shopDao.createShop("速卖通", shop, resource_owner, access_token, refresh_token, refresh_token_timeout);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	private String auth_signature(String data, String secret) {
		return hex(hmacSha1(data, secret)).toUpperCase();
	}

	private String hex(byte[] rawHmac) {
		try {
			byte[] hexBytes = new Hex().encode(rawHmac);
			return new String(hexBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private byte[] hmacSha1(String value, String key) {
		try {
			byte[] keyBytes = key.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(value.getBytes());
			return rawHmac;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
