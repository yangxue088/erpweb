package com.erp.service.aliexpress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(locations = "classpath:application-context.xml"), @ContextConfiguration(locations = "classpath:dispatcher/dispatcher-context.xml") })
public class AliExpressServiceTest {

	@Autowired
	private AliExpressService aliExpressService;

	private int tokenId = 3;

	@Test
	public void testFindOrderListSimpleQuery() {
		SimpleOrderListVO simpleOrderListVO = aliExpressService.findOrderListSimpleQuery(tokenId);
		for (SimpleOrderItemVO simpleOrderItemVO : simpleOrderListVO.getOrderList()) {
			long orderId = simpleOrderItemVO.getOrderId();
			
			OrderTradeInfo orderTradeInfo = aliExpressService.findOrderTradeInfo(tokenId, orderId);
			System.out.println(orderTradeInfo);
			
			TpOpenAddressDTO tpOpenAddressDTO = aliExpressService.findOrderReceiptInfo(tokenId, orderId);
			System.out.println(tpOpenAddressDTO);
			
			OrderBaseInfo orderBaseInfo = aliExpressService.findOrderBaseInfo(tokenId, orderId);
			System.out.println(orderBaseInfo);
		}

	}

}
