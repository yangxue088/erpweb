package com.erp.service.order;

import java.util.ArrayList;
import java.util.List;

public class OrderVo {

	private List<SkuVo> skuVos = new ArrayList<SkuVo>();

	private String totalPrice;

	private String priceCur;

	private String receipt;

	private String country;

	private String orderNO;

	private String orderStatus;

	private String orderTime;

	private String payTime;

	public OrderVo() {
		super();
	}

	public OrderVo(String totalPrice, String priceCur, String receipt, String country, String orderNO, String orderStatus, String orderTime, String payTime) {
		super();
		this.totalPrice = totalPrice;
		this.priceCur = priceCur;
		this.receipt = receipt;
		this.country = country;
		this.orderNO = orderNO;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		this.payTime = payTime;
	}

	public void addSkuVo(SkuVo skuVo) {
		this.skuVos.add(skuVo);
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPriceCur() {
		return priceCur;
	}

	public void setPriceCur(String priceCur) {
		this.priceCur = priceCur;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public List<SkuVo> getSkuVos() {
		return skuVos;
	}

	public void setSkuVos(List<SkuVo> skuVos) {
		this.skuVos = skuVos;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
