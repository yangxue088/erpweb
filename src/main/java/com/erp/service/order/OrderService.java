package com.erp.service.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.order.OrderDao;
import com.erp.dao.shop.TokenDao;
import com.erp.service.aliexpress.AliExpressService;
import com.erp.service.aliexpress.ChildOrderDTO;
import com.erp.service.aliexpress.OrderBaseInfo;
import com.erp.service.aliexpress.OrderTradeInfo;
import com.erp.service.aliexpress.SimpleOrderItemVO;
import com.erp.service.aliexpress.SimpleOrderListVO;
import com.erp.service.aliexpress.SimpleOrderProductVO;
import com.erp.service.aliexpress.TpOpenAddressDTO;
import com.erp.service.shop.Shop;
import com.erp.service.shop.ShopService;

@Service
public class OrderService {

	@Autowired
	private ShopService shopService;

	@Autowired
	private AliExpressService aliExpressService;

	@Autowired
	private TokenDao tokenDao;

	@Autowired
	private OrderDao orderDao;

	public String sync() {
		List<Shop> shops = shopService.listShop();
		for (Shop shop : shops) {
			int tokenId = shop.getTokenId();
			if (Shop.TYPE_ALIEXPRESS.equals(shop.getType())) {
				String lastGmtCreate = orderDao.getAliLastGmtCreate(tokenId);

				String createDateStart = lastGmtCreate;
				String createDateEnd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());

				int page = 1;
				int pageSize = 20;

				int lenth = 0;
				do {
					SimpleOrderListVO simpleOrderListVO = aliExpressService.findOrderListSimpleQuery(tokenId, page, pageSize, createDateStart, createDateEnd);
					for (SimpleOrderItemVO simpleOrderItemVO : simpleOrderListVO.getOrderList()) {
						orderDao.createAliOrder(tokenId, simpleOrderItemVO);

						long orderId = simpleOrderItemVO.getOrderId();

						for (SimpleOrderProductVO simpleOrderProductVO : simpleOrderItemVO.getProductList()) {
							orderDao.createAliOrderProduct(orderId, simpleOrderProductVO);
						}

						OrderTradeInfo orderTradeInfo = aliExpressService.findOrderTradeInfo(tokenId, orderId);
						orderDao.createAliOrderTrade(orderTradeInfo);

						for (ChildOrderDTO childOrderDTO : orderTradeInfo.getChildOrderList()) {
							orderDao.createAliOrderTradeChild(orderTradeInfo.getId(), childOrderDTO);
						}

						TpOpenAddressDTO tpOpenAddressDTO = aliExpressService.findOrderReceiptInfo(tokenId, orderId);
						orderDao.createAliOrderReceipt(orderId, tpOpenAddressDTO);

						OrderBaseInfo orderBaseInfo = aliExpressService.findOrderBaseInfo(tokenId, orderId);
						orderDao.createAliOrderBase(orderId, orderBaseInfo);
					}

					page += 1;
					lenth = simpleOrderListVO.getOrderList().length;
				} while (lenth == pageSize);
			}
		}

		return "";
	}
}
