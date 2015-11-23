package com.erp.service.aliexpress;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class aop_signature {

	static String client_id = "2901405";
	static String client_secret = "jVki3DaGtA";
	static String redirect_uri = "http://localhost:8080";
	static String state = "test_state";

	public static void main(String[] args) {
		auth_request();
	}

	public static void auth_request() {
		SortedMap<String, String> map = new TreeMap<String, String>();
		map.put("client_id", client_id);
		map.put("site", "aliexpress");
		map.put("redirect_uri", redirect_uri);
		map.put("state", state);

		String data = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			data += entry.getKey() + entry.getValue();
		}

		String _aop_signature = signature(data, client_secret);

		String url = String.format("http://authhz.alibaba.com/auth/authorize.htm?client_id=%s&site=aliexpress&redirect_uri=%s&state=%s&_aop_signature=%s", client_id, redirect_uri, state, _aop_signature);

		System.out.println(url);
	}

	public static String signature(String data, String secret) {
		return hex(hmacSha1(data, secret)).toUpperCase();
	}

	public static String hex(byte[] rawHmac) {
		try {
			// Convert raw bytes to Hex
			byte[] hexBytes = new Hex().encode(rawHmac);

			// Covert array of Hex bytes to a String
			return new String(hexBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] hmacSha1(String value, String key) {
		try {
			// Get an hmac_sha1 key from the raw key bytes
			byte[] keyBytes = key.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

			// Get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			// Compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(value.getBytes());

			return rawHmac;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
