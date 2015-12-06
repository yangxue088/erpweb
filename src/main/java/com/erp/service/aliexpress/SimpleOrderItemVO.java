package com.erp.service.aliexpress;

import java.util.Arrays;

public class SimpleOrderItemVO {
	
	private String bizType;// 订单类型
	private String gmtCreate;// 交易创建时间
	private String gmtModified;// 订单修改时间
	private String memo;// 订单备注
	private long orderId;// 订单ID
	private String orderStatus;// 订单状态
	private Long timeoutLeftTime;// 超时剩余时间
	private SimpleOrderProductVO[] productList;//

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getTimeoutLeftTime() {
		return timeoutLeftTime;
	}

	public void setTimeoutLeftTime(Long timeoutLeftTime) {
		this.timeoutLeftTime = timeoutLeftTime;
	}

	public SimpleOrderProductVO[] getProductList() {
		return productList;
	}

	public void setProductList(SimpleOrderProductVO[] productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "SimpleOrderItemVO [bizType=" + bizType + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", memo=" + memo + ", orderId=" + orderId + ", orderStatus=" + orderStatus + ", timeoutLeftTime=" + timeoutLeftTime + ", productList=" + Arrays.toString(productList) + "]";
	}
}
