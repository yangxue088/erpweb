package com.erp.service.aliexpress;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AliClient {

	private String key = "2901405";

	private String secret = "jVki3DaGtA";

	public String getAuthUrl(String redirectUrl, String state) {
		String data = sort(map("client_id", key, "site", "aliexpress", "redirect_uri", redirectUrl, "state", state));
		String _aop_signature = signature(data);
		return String.format("http://authhz.alibaba.com/auth/authorize.htm?client_id=%s&site=aliexpress&redirect_uri=%s&state=%s&_aop_signature=%s", key, redirectUrl, state, _aop_signature);
	}

	private CloseableHttpClient httpClient = HttpClients.createDefault();

	public Map<String, String> getToken(String code) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("grant_type", "authorization_code"));
		nvps.add(new BasicNameValuePair("need_refresh_token", "true"));
		nvps.add(new BasicNameValuePair("client_id", key));
		nvps.add(new BasicNameValuePair("client_secret", secret));
		nvps.add(new BasicNameValuePair("redirect_uri", "default"));
		nvps.add(new BasicNameValuePair("code", code));

		String url = String.format("https://gw.api.alibaba.com/openapi/http/1/system.oauth2/getToken/%s", key);

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		Map<String, String> result = new HashMap<String, String>();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);
			result = new ObjectMapper().readValue(json.getBytes(), new TypeReference<Map<String, String>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, String> refreshToken(String refreshToken) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("grant_type", "refresh_token"));
		nvps.add(new BasicNameValuePair("client_id", key));
		nvps.add(new BasicNameValuePair("client_secret", secret));
		nvps.add(new BasicNameValuePair("refresh_token", refreshToken));

		String url = String.format("https://gw.api.alibaba.com/openapi/param2/1/system.oauth2/getToken/%s", key);

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		Map<String, String> result = new HashMap<String, String>();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);
			result = new ObjectMapper().readValue(json.getBytes(), new TypeReference<Map<String, String>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public String invokeApi(String accessToken, String method, Object... params) {
		String result = "";

		String url_path = String.format("param2/1/aliexpress.open/%s/%s", method, key);
		Map<String, String> map = map(params);
		map.put("_aop_timestamp", String.valueOf(new Date().getTime()));
		map.put("access_token", accessToken);

		String data = sort(map);
		map.put("_aop_signature", signature(url_path + data));

		String url = String.format("http://gw.api.alibaba.com/openapi/%s?%s", url_path, join(map));

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private String signature(String data) {
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

	private SortedMap<String, String> map(Object... params) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		for (int i = 0; i < params.length; i += 2) {
			map.put(String.valueOf(params[i]), String.valueOf(params[i + 1]));
		}
		return map;
	}

	private String sort(Map<String, String> map) {
		String data = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			data += entry.getKey() + entry.getValue();
		}
		return data;
	}

	private String join(Map<String, String> params) {
		List<String> ps = new ArrayList<String>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			ps.add(entry.getKey() + "=" + entry.getValue());
		}
		return StringUtils.join(ps, "&");
	}
}
