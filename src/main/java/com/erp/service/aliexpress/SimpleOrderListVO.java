package com.erp.service.aliexpress;

import java.util.Arrays;

public class SimpleOrderListVO {

	private Integer totalItem;// 总数量(SC订单不包含在结果中）
	private SimpleOrderItemVO[] orderList;// 订单数组

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public SimpleOrderItemVO[] getOrderList() {
		return orderList;
	}

	public void setOrderList(SimpleOrderItemVO[] orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "SimpleOrderListVO [totalItem=" + totalItem + ", orderList=" + Arrays.toString(orderList) + "]";
	}

}
