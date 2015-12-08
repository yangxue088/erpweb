package com.erp.dao.order;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.erp.service.aliexpress.ChildOrderDTO;
import com.erp.service.aliexpress.OrderBaseInfo;
import com.erp.service.aliexpress.OrderTradeInfo;
import com.erp.service.aliexpress.SimpleOrderItemVO;
import com.erp.service.aliexpress.SimpleOrderProductVO;
import com.erp.service.aliexpress.TpOpenAddressDTO;

@Repository
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getAliLastGmtCreate(int tokenId) {
		String lastGmtCreate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select max(gmtCreate) as lastGmtCreate from alibaba_order where tokenId=? order by orderId", new Object[] { tokenId });
		while (rs.next()) {
			Timestamp maxGmtCreate = rs.getTimestamp("lastGmtCreate");
			if (maxGmtCreate != null) {
				lastGmtCreate = sdf.format(maxGmtCreate);
			}
		}
		return lastGmtCreate;
	}

	public void createAliOrder(int tokenId, SimpleOrderItemVO simpleOrderItemVO) {
		jdbcTemplate.update("insert into alibaba_order(bizType, gmtCreate, gmtModified, memo, orderId, orderStatus, timeoutLeftTime, tokenId) values(?,?,?,?,?,?,?,?)", new AliOrderSetter(tokenId, simpleOrderItemVO));
	}

	public void createAliOrderProduct(long orderId, SimpleOrderProductVO simpleOrderProductVO) {
		jdbcTemplate.update("insert into alibaba_order_product(childId, goodsPrepareTime, moneyBack3x, productCount, productId, productImgUrl, productName, productSnapUrl, productUnit, productUnitPrice, productUnitPriceCur, skuCode, sonOrderStatus, orderId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new AliOrderProductSetter(orderId, simpleOrderProductVO));
	}

	public void createAliOrderTrade(OrderTradeInfo orderTradeInfo) {
		jdbcTemplate.update("insert into alibaba_order_trade(orderId, initOderAmount, initOderAmountCur, isPhone, logisticsAmount, logisticsAmountCur, orderAmount, orderAmountCur) values(?,?,?,?,?,?,?,?)", new AliOrderTradeSetter(orderTradeInfo));
	}

	public void createAliOrderTradeChild(long orderId, ChildOrderDTO childOrderDTO) {
		jdbcTemplate.update("insert into alibaba_order_trade_child(frozenStatus, fundStatus, childId, initOrderAmt, initOrderAmtCur, issueStatus, lotNum, orderStatus, productAttributes, productCount, productId, productName, productPrice, productPriceCur, productStandard, productUnit, skuCode, orderId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new AliOrderTradeChildSetter(orderId, childOrderDTO));
	}

	public void createAliOrderReceipt(long orderId, TpOpenAddressDTO tpOpenAddressDTO) {
		jdbcTemplate.update("insert into alibaba_order_receipt(address, address2, city, contactPerson, country, detailAddress, faxArea, faxCountry, faxNumber, mobileNo, phoneArea, phoneCountry, phoneNumber, province, zip, orderId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new AliOrderReceiptSetter(orderId, tpOpenAddressDTO));
	}

	public void createAliOrderBase(long orderId, OrderBaseInfo orderBaseInfo) {
		jdbcTemplate.update("insert into alibaba_order_base(frozenStatus, fundStatus, gmtCreate, gmtModified, issueStatus, loanStatus, logisticsStatus, orderStatus, sellerOperatorLoginId, sellerSignerFullname, orderId) values(?,?,?,?,?,?,?,?,?,?,?)", new AliOrderBaseSetter(orderId, orderBaseInfo));
	}

	private class AliOrderBaseSetter implements PreparedStatementSetter {

		private long orderId;
		private OrderBaseInfo orderBaseInfo;

		public AliOrderBaseSetter(long orderId, OrderBaseInfo orderBaseInfo) {
			this.orderId = orderId;
			this.orderBaseInfo = orderBaseInfo;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, orderBaseInfo.getFrozenStatus());
			ps.setString(2, orderBaseInfo.getFundStatus());
			ps.setString(3, orderBaseInfo.getGmtCreate());
			ps.setString(4, orderBaseInfo.getGmtModified());
			ps.setString(5, orderBaseInfo.getIssueStatus());
			ps.setString(6, orderBaseInfo.getLoanStatus());
			ps.setString(7, orderBaseInfo.getLogisticsStatus());
			ps.setString(8, orderBaseInfo.getOrderStatus());
			ps.setString(9, orderBaseInfo.getSellerOperatorLoginId());
			ps.setString(10, orderBaseInfo.getSellerSignerFullname());
			ps.setLong(11, orderId);
		}

	}

	private class AliOrderReceiptSetter implements PreparedStatementSetter {

		private long orderId;
		private TpOpenAddressDTO tpOpenAddressDTO;

		public AliOrderReceiptSetter(long orderId, TpOpenAddressDTO tpOpenAddressDTO) {
			this.orderId = orderId;
			this.tpOpenAddressDTO = tpOpenAddressDTO;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, tpOpenAddressDTO.getAddress());
			ps.setString(2, tpOpenAddressDTO.getAddress2());
			ps.setString(3, tpOpenAddressDTO.getCity());
			ps.setString(4, tpOpenAddressDTO.getContactPerson());
			ps.setString(5, tpOpenAddressDTO.getCountry());
			ps.setString(6, tpOpenAddressDTO.getDetailAddress());
			ps.setString(7, tpOpenAddressDTO.getFaxArea());
			ps.setString(8, tpOpenAddressDTO.getFaxCountry());
			ps.setString(9, tpOpenAddressDTO.getFaxNumber());
			ps.setString(10, tpOpenAddressDTO.getMobileNo());
			ps.setString(11, tpOpenAddressDTO.getPhoneArea());
			ps.setString(12, tpOpenAddressDTO.getPhoneCountry());
			ps.setString(13, tpOpenAddressDTO.getPhoneNumber());
			ps.setString(14, tpOpenAddressDTO.getProvince());
			ps.setString(15, tpOpenAddressDTO.getZip());
			ps.setLong(16, orderId);
		}
	}

	private class AliOrderTradeChildSetter implements PreparedStatementSetter {

		private long orderId;
		private ChildOrderDTO childOrderDTO;

		public AliOrderTradeChildSetter(long orderId, ChildOrderDTO childOrderDTO) {
			this.orderId = orderId;
			this.childOrderDTO = childOrderDTO;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, childOrderDTO.getFrozenStatus());
			ps.setString(2, childOrderDTO.getFundStatus());
			ps.setLong(3, childOrderDTO.getId());
			ps.setString(4, childOrderDTO.getInitOrderAmt());
			ps.setString(5, childOrderDTO.getInitOrderAmtCur());
			ps.setString(6, childOrderDTO.getIssueStatus());
			ps.setInt(7, childOrderDTO.getLotNum());
			ps.setString(8, childOrderDTO.getOrderStatus());
			ps.setString(9, childOrderDTO.getProductAttributes());
			ps.setInt(10, childOrderDTO.getProductCount());
			ps.setLong(11, childOrderDTO.getProductId());
			ps.setString(12, childOrderDTO.getProductName());
			ps.setString(13, childOrderDTO.getProductPrice());
			ps.setString(14, childOrderDTO.getProductPriceCur());
			ps.setString(15, childOrderDTO.getProductStandard());
			ps.setString(16, childOrderDTO.getProductUnit());
			ps.setString(17, childOrderDTO.getSkuCode());
			ps.setLong(18, orderId);
		}

	}

	private class AliOrderTradeSetter implements PreparedStatementSetter {

		private OrderTradeInfo orderTradeInfo;

		public AliOrderTradeSetter(OrderTradeInfo orderTradeInfo) {
			this.orderTradeInfo = orderTradeInfo;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setLong(1, orderTradeInfo.getId());
			ps.setString(2, orderTradeInfo.getInitOderAmount());
			ps.setString(3, orderTradeInfo.getInitOderAmountCur());
			ps.setBoolean(4, orderTradeInfo.getIsPhone());
			ps.setString(5, orderTradeInfo.getLogisticsAmount());
			ps.setString(6, orderTradeInfo.getLogisticsAmountCur());
			ps.setString(7, orderTradeInfo.getOrderAmount());
			ps.setString(8, orderTradeInfo.getOrderAmountCur());
		}
	}

	private class AliOrderProductSetter implements PreparedStatementSetter {

		private long orderId;
		private SimpleOrderProductVO simpleOrderProductVO;

		public AliOrderProductSetter(long orderId, SimpleOrderProductVO simpleOrderProductVO) {
			this.orderId = orderId;
			this.simpleOrderProductVO = simpleOrderProductVO;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setLong(1, simpleOrderProductVO.getChildId());
			ps.setInt(2, simpleOrderProductVO.getGoodsPrepareTime() == null ? -1 : simpleOrderProductVO.getGoodsPrepareTime());
			ps.setBoolean(3, simpleOrderProductVO.isMoneyBack3x());
			ps.setInt(4, simpleOrderProductVO.getProductCount());
			ps.setLong(5, simpleOrderProductVO.getProductId());
			ps.setString(6, simpleOrderProductVO.getProductImgUrl());
			ps.setString(7, simpleOrderProductVO.getProductName());
			ps.setString(8, simpleOrderProductVO.getProductSnapUrl());
			ps.setString(9, simpleOrderProductVO.getProductUnit());
			ps.setString(10, simpleOrderProductVO.getProductUnitPrice());
			ps.setString(11, simpleOrderProductVO.getProductUnitPriceCur());
			ps.setString(12, simpleOrderProductVO.getSkuCode());
			ps.setString(13, simpleOrderProductVO.getSonOrderStatus());
			ps.setLong(14, orderId);
		}

	}

	private class AliOrderSetter implements PreparedStatementSetter {

		private int tokenId;
		private SimpleOrderItemVO simpleOrderItemVO;

		public AliOrderSetter(int tokenId, SimpleOrderItemVO simpleOrderItemVO) {
			this.tokenId = tokenId;
			this.simpleOrderItemVO = simpleOrderItemVO;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			try {
				ps.setString(1, simpleOrderItemVO.getBizType());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ps.setTimestamp(2, new Timestamp(sdf.parse(simpleOrderItemVO.getGmtCreate()).getTime()));
				ps.setTimestamp(3, new Timestamp(sdf.parse(simpleOrderItemVO.getGmtModified()).getTime()));

				ps.setString(4, simpleOrderItemVO.getMemo());
				ps.setLong(5, simpleOrderItemVO.getOrderId());
				ps.setString(6, simpleOrderItemVO.getOrderStatus());
				ps.setLong(7, simpleOrderItemVO.getTimeoutLeftTime() == null ? -1 : simpleOrderItemVO.getTimeoutLeftTime());
				ps.setInt(8, tokenId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}

}
