package com.erp.service.aliexpress;

public class SimpleOrderProductVO {
	
	private Long childId;// 子订单号
	private Integer goodsPrepareTime;// 备货时间
	private boolean moneyBack3x;// 是否支持假一赔三
	private Integer productCount;// 商品数量
	private Long productId;// 商品ID
	private String productImgUrl;// 商品主图Url
	private String productName;// 商品名称
	private String productSnapUrl;// 快照Url
	private String productUnit;// 商品单位
	private String productUnitPrice;// 商品单价
	private String productUnitPriceCur;// 商品货币名称
	private String skuCode;// 商品编码
	private String sonOrderStatus;// 子订单状态

	public Long getChildId() {
		return childId;
	}

	public void setChildId(Long childId) {
		this.childId = childId;
	}

	public Integer getGoodsPrepareTime() {
		return goodsPrepareTime;
	}

	public void setGoodsPrepareTime(Integer goodsPrepareTime) {
		this.goodsPrepareTime = goodsPrepareTime;
	}

	public boolean isMoneyBack3x() {
		return moneyBack3x;
	}

	public void setMoneyBack3x(boolean moneyBack3x) {
		this.moneyBack3x = moneyBack3x;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSnapUrl() {
		return productSnapUrl;
	}

	public void setProductSnapUrl(String productSnapUrl) {
		this.productSnapUrl = productSnapUrl;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public String getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(String productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public String getProductUnitPriceCur() {
		return productUnitPriceCur;
	}

	public void setProductUnitPriceCur(String productUnitPriceCur) {
		this.productUnitPriceCur = productUnitPriceCur;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSonOrderStatus() {
		return sonOrderStatus;
	}

	public void setSonOrderStatus(String sonOrderStatus) {
		this.sonOrderStatus = sonOrderStatus;
	}

	@Override
	public String toString() {
		return "SimpleOrderProductVO [childId=" + childId + ", goodsPrepareTime=" + goodsPrepareTime + ", moneyBack3x=" + moneyBack3x + ", productCount=" + productCount + ", productId=" + productId + ", productImgUrl=" + productImgUrl + ", productName=" + productName + ", productSnapUrl=" + productSnapUrl + ", productUnit=" + productUnit + ", productUnitPrice=" + productUnitPrice + ", productUnitPriceCur=" + productUnitPriceCur + ", skuCode=" + skuCode + ", sonOrderStatus=" + sonOrderStatus + ", getChildId()=" + getChildId() + ", getGoodsPrepareTime()=" + getGoodsPrepareTime() + ", isMoneyBack3x()=" + isMoneyBack3x() + ", getProductCount()=" + getProductCount() + ", getProductId()=" + getProductId() + ", getProductImgUrl()=" + getProductImgUrl() + ", getProductName()=" + getProductName()
				+ ", getProductSnapUrl()=" + getProductSnapUrl() + ", getProductUnit()=" + getProductUnit() + ", getProductUnitPrice()=" + getProductUnitPrice() + ", getProductUnitPriceCur()=" + getProductUnitPriceCur() + ", getSkuCode()=" + getSkuCode() + ", getSonOrderStatus()=" + getSonOrderStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
