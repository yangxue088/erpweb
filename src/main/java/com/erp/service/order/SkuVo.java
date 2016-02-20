package com.erp.service.order;

public class SkuVo {

	private String productSku;

	private String productNum;

	private String unitPrice;

	private String unitPriceCur;

	public SkuVo() {
		super();
	}

	public SkuVo(String productSku, String productNum, String unitPrice, String unitPriceCur) {
		super();
		this.productSku = productSku;
		this.productNum = productNum;
		this.unitPrice = unitPrice;
		this.unitPriceCur = unitPriceCur;
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitPriceCur() {
		return unitPriceCur;
	}

	public void setUnitPriceCur(String unitPriceCur) {
		this.unitPriceCur = unitPriceCur;
	}

}
