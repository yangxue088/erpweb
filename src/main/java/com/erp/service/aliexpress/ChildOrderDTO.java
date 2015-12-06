package com.erp.service.aliexpress;

public class ChildOrderDTO {

	private String frozenStatus;// 冻结状态("NO_FROZEN"无冻结；"IN_FROZEN"冻结中；)
	private String fundStatus;// 资金状态(NOT_PAY,未付款； PAY_SUCCESS,付款成功； WAIT_SELLER_CHECK，卖家验款)
	private Long id;// 子订单ID
	private String initOrderAmt;// 子订单初始金额
	private String initOrderAmtCur;// 货币单位
	private String issueStatus;// 纠纷状态("NO_ISSUE"无纠纷；"IN_ISSUE"纠纷中；“END_ISSUE”纠纷结束。) frozenStatus:冻结状态("NO_FROZEN"无冻结；"IN_FROZEN"冻结中；)
	private Integer lotNum;// lot数量
	private String orderStatus;// 子订单状态
	private String productAttributes;// 商品属性
	private Integer productCount;// 商品数量
	private Long productId;// 商品ID
	private String productName;// 商品名称
	private String productPrice;// 商品价格
	private String productPriceCur;// 货币单位
	private String productStandard;// 产品规格
	private String productUnit;// 产品单位
	private String skuCode;// SKU编码

	public String getFrozenStatus() {
		return frozenStatus;
	}

	public void setFrozenStatus(String frozenStatus) {
		this.frozenStatus = frozenStatus;
	}

	public String getFundStatus() {
		return fundStatus;
	}

	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitOrderAmt() {
		return initOrderAmt;
	}

	public void setInitOrderAmt(String initOrderAmt) {
		this.initOrderAmt = initOrderAmt;
	}

	public String getInitOrderAmtCur() {
		return initOrderAmtCur;
	}

	public void setInitOrderAmtCur(String initOrderAmtCur) {
		this.initOrderAmtCur = initOrderAmtCur;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public Integer getLotNum() {
		return lotNum;
	}

	public void setLotNum(Integer lotNum) {
		this.lotNum = lotNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(String productAttributes) {
		this.productAttributes = productAttributes;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPriceCur() {
		return productPriceCur;
	}

	public void setProductPriceCur(String productPriceCur) {
		this.productPriceCur = productPriceCur;
	}

	public String getProductStandard() {
		return productStandard;
	}

	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	@Override
	public String toString() {
		return "ChildOrderDTO [frozenStatus=" + frozenStatus + ", fundStatus=" + fundStatus + ", id=" + id + ", initOrderAmt=" + initOrderAmt + ", initOrderAmtCur=" + initOrderAmtCur + ", issueStatus=" + issueStatus + ", lotNum=" + lotNum + ", orderStatus=" + orderStatus + ", productAttributes=" + productAttributes + ", productCount=" + productCount + ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productPriceCur=" + productPriceCur + ", productStandard=" + productStandard + ", productUnit=" + productUnit + ", skuCode=" + skuCode + "]";
	}

	
}
