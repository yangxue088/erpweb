package com.erp.service.aliexpress;

import java.util.Arrays;

public class OrderTradeInfo {

	private Long id;// 订单ID
	private String initOderAmount;// 订单初始金额
	private String initOderAmountCur;// 订单金额货币单位
	private Boolean isPhone;// 是否手机订单
	private String logisticsAmount;// 物流金额
	private String logisticsAmountCur;// 物流金额货币单位
	private String orderAmount;// 订单金额
	private String orderAmountCur;// 货币单位
	private ChildOrderDTO[] childOrderList;//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitOderAmount() {
		return initOderAmount;
	}

	public void setInitOderAmount(String initOderAmount) {
		this.initOderAmount = initOderAmount;
	}

	public String getInitOderAmountCur() {
		return initOderAmountCur;
	}

	public void setInitOderAmountCur(String initOderAmountCur) {
		this.initOderAmountCur = initOderAmountCur;
	}

	public Boolean getIsPhone() {
		return isPhone;
	}

	public void setIsPhone(Boolean isPhone) {
		this.isPhone = isPhone;
	}

	public String getLogisticsAmount() {
		return logisticsAmount;
	}

	public void setLogisticsAmount(String logisticsAmount) {
		this.logisticsAmount = logisticsAmount;
	}

	public String getLogisticsAmountCur() {
		return logisticsAmountCur;
	}

	public void setLogisticsAmountCur(String logisticsAmountCur) {
		this.logisticsAmountCur = logisticsAmountCur;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderAmountCur() {
		return orderAmountCur;
	}

	public void setOrderAmountCur(String orderAmountCur) {
		this.orderAmountCur = orderAmountCur;
	}

	public ChildOrderDTO[] getChildOrderList() {
		return childOrderList;
	}

	public void setChildOrderList(ChildOrderDTO[] childOrderList) {
		this.childOrderList = childOrderList;
	}

	@Override
	public String toString() {
		return "OrderTradeInfo [id=" + id + ", initOderAmount=" + initOderAmount + ", initOderAmountCur=" + initOderAmountCur + ", isPhone=" + isPhone + ", logisticsAmount=" + logisticsAmount + ", logisticsAmountCur=" + logisticsAmountCur + ", orderAmount=" + orderAmount + ", orderAmountCur=" + orderAmountCur + ", childOrderList=" + Arrays.toString(childOrderList) + "]";
	}

}
