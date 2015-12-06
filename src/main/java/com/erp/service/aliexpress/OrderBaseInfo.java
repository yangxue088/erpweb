package com.erp.service.aliexpress;

public class OrderBaseInfo {

	private String frozenStatus;// 冻结状态("NO_FROZEN"无冻结；"IN_FROZEN"冻结中；)
	private String fundStatus;// 资金状态(NOT_PAY,未付款； PAY_SUCCESS,付款成功；
								// WAIT_SELLER_CHECK，卖家验款)
	private String gmtCreate;// 创建时间
	private String gmtModified;// 修改时间
	private String issueStatus;// 纠纷状态("NO_ISSUE"无纠纷；"IN_ISSUE"纠纷中；“END_ISSUE”纠纷结束。)
								// frozenStatus:冻结状态("NO_FROZEN"无冻结；"IN_FROZEN"冻结中；)
	private String loanStatus;// 订单放款状态：wait_loan
	private String logisticsStatus;// 物流状态
	private String orderStatus;// 订单状态
	private String sellerOperatorLoginId;// 卖家ID
	private String sellerSignerFullname;// 卖家全名

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

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getLogisticsStatus() {
		return logisticsStatus;
	}

	public void setLogisticsStatus(String logisticsStatus) {
		this.logisticsStatus = logisticsStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSellerOperatorLoginId() {
		return sellerOperatorLoginId;
	}

	public void setSellerOperatorLoginId(String sellerOperatorLoginId) {
		this.sellerOperatorLoginId = sellerOperatorLoginId;
	}

	public String getSellerSignerFullname() {
		return sellerSignerFullname;
	}

	public void setSellerSignerFullname(String sellerSignerFullname) {
		this.sellerSignerFullname = sellerSignerFullname;
	}

	@Override
	public String toString() {
		return "OrderBaseInfo [frozenStatus=" + frozenStatus + ", fundStatus=" + fundStatus + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", issueStatus=" + issueStatus + ", loanStatus=" + loanStatus + ", logisticsStatus=" + logisticsStatus + ", orderStatus=" + orderStatus + ", sellerOperatorLoginId=" + sellerOperatorLoginId + ", sellerSignerFullname=" + sellerSignerFullname + "]";
	}

}
