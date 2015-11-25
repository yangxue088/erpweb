package com.erp.service.aliexpress;

public class AliToken {

	private int id;

	private String aliId;

	private String resourceOwner;

	private String refreshToken;

	private String refreshTokenTimeout;

	private String accessToken;

	private String expiresIn;

	private String updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAliId() {
		return aliId;
	}

	public void setAliId(String aliId) {
		this.aliId = aliId;
	}

	public String getResourceOwner() {
		return resourceOwner;
	}

	public void setResourceOwner(String resourceOwner) {
		this.resourceOwner = resourceOwner;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshTokenTimeout() {
		return refreshTokenTimeout;
	}

	public void setRefreshTokenTimeout(String refreshTokenTimeout) {
		this.refreshTokenTimeout = refreshTokenTimeout;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
