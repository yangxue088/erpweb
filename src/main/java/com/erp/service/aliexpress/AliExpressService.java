package com.erp.service.aliexpress;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
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
		String data = sort_params(to_map("client_id", aliexpress_client_id, "site", "aliexpress", "redirect_uri", redirect_uri, "state", state));
		String _aop_signature = auth_signature(data);
		String url = String.format("http://authhz.alibaba.com/auth/authorize.htm?client_id=%s&site=aliexpress&redirect_uri=%s&state=%s&_aop_signature=%s", aliexpress_client_id, redirect_uri, state, _aop_signature);
		return url;
	}

	private SortedMap<String, String> to_map(Object... params) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < params.length; i += 2) {
			map.put(String.valueOf(params[i]), String.valueOf(params[i + 1]));
		}
		return map;
	}

	private String sort_params(Map<String, String> map) {
		String data = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			data += entry.getKey() + entry.getValue();
		}
		return data;
	}

	public boolean get_token(String shop, String code, Boolean need_refresh_token) {
		String url = String.format("https://gw.api.alibaba.com/openapi/http/1/system.oauth2/getToken/%s", aliexpress_client_id);

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
		nvps.add(new BasicNameValuePair("need_refresh_token", need_refresh_token.toString()));
		nvps.add(new BasicNameValuePair("client_id", aliexpress_client_id));
		nvps.add(new BasicNameValuePair("client_secret", aliexpress_client_secret));
		nvps.add(new BasicNameValuePair("redirect_uri", "default"));
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

	private String auth_signature(String data) {
		return hex(hmacSha1(data, aliexpress_client_secret)).toUpperCase();
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

	public String call_api(String access_token, String api_method, Object... params) {
		String url_path = String.format("param2/1/aliexpress.open/%s/%s", api_method, aliexpress_client_id);

		Map<String, String> map = to_map(params);
		map.put("_aop_timestamp", String.valueOf(new Date().getTime()));
		map.put("access_token", access_token);

		String data = sort_params(map);
		map.put("_aop_signature", api_signature(url_path, data));

		String url = String.format("http://gw.api.alibaba.com/openapi/%s?%s", url_path, to_uri(map));

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			
			System.out.println(response.getStatusLine());

			// 授权过期或者授权失效
			if (response.getStatusLine().getStatusCode() == 401) {
				
			}

			System.out.println(Arrays.asList(response.getAllHeaders()));

			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);

			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "";
	}

	private String to_uri(Map<String, String> params) {
		List<String> ps = new ArrayList<String>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			ps.add(entry.getKey() + "=" + entry.getValue());
		}
		return StringUtils.join(ps, "&");
	}

	private String api_signature(String url_path, String data) {
		return hex(hmacSha1(url_path + data, aliexpress_client_secret)).toUpperCase();
	}

	public String getAccessToken(String account_id) {
		return "";
	}

}
