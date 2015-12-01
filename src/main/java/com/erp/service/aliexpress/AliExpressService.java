package com.erp.service.aliexpress;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.shop.ShopDao;
import com.erp.dao.shop.TokenDao;
import com.erp.service.shop.Shop;

@Service
public class AliExpressService {

	@Autowired
	private AliClient aliClient;

	@Autowired
	private ShopDao shopDao;

	@Autowired
	private TokenDao tokenDao;

	public String authUrl(String redirectUrl, String state) {
		return aliClient.getAuthUrl(redirectUrl, state);
	}

	public boolean getToken(String name, String code) {
		Map<String, String> map = aliClient.getToken(code);

		if (map.size() == 0 || map.containsKey("error=invalid_request")) {
			System.err.println("shop get token fail, return map:" + map);
			return false;
		}

		String aliId = map.get("aliId");
		String resource_owner = map.get("resource_owner");

		String refresh_token = map.get("refresh_token");
		String refresh_token_timeout = map.get("refresh_token_timeout");

		String access_token = map.get("access_token");
		String expires_in = map.get("expires_in");

		Shop shop = shopDao.getShop(name);
		if (shop == null) {

			Integer token_id = tokenDao.createAliToken(aliId, resource_owner, access_token, expires_in, refresh_token, refresh_token_timeout);
			shopDao.createShop(Shop.TYPE_ALIEXPRESS, name, token_id);
		} else {

			AliToken aliToken = new AliToken();
			aliToken.setAliId(aliId);
			aliToken.setResourceOwner(resource_owner);
			aliToken.setRefreshToken(refresh_token);
			aliToken.setRefreshTokenTimeout(refresh_token_timeout);
			aliToken.setAccessToken(access_token);
			aliToken.setExpiresIn(expires_in);

			tokenDao.updateAliToken(shop.getTokenId(), aliToken);
		}

		return true;
	}

	public void findOrderListQuery(int tokenId) {
		String method = "api.findOrderListQuery";
		Object[] params = new Object[] { "page", 1, "pageSize", 10 };

		String json = invokeApi(tokenId, method, params);
		
		System.out.println(json);
	}

	private String invokeApi(int tokenId, String method, Object... params) {
		AliToken token = tokenDao.getAliToken(tokenId);
		String accessToken = token.getAccessToken();

		String json = aliClient.invokeApi(accessToken, method, params);
		if (json.contains("error_code")) {
			Map<String, String> map = aliClient.refreshToken(token.getRefreshToken());

			accessToken = map.get("access_token");
			String expires_in = map.get("expires_in");

			token.setAccessToken(accessToken);
			token.setExpiresIn(expires_in);

			tokenDao.updateAliToken(tokenId, token);

			json = aliClient.invokeApi(accessToken, method, params);

			if (json.contains("error_code")) {
				json = "";
				System.err.println("invoke api error, maybe need reauth, json:" + json);
			}
		}

		return json;
	}

}
