package com.erp.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.shop.TokenDao;
import com.erp.service.aliexpress.AliExpressService;
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
	
	public String sync(){
		List<Shop> shops = shopService.listShop();
		for(Shop shop : shops){
			int tokenId = shop.getTokenId();
			if(Shop.TYPE_ALIEXPRESS.equals(shop.getType())){
				aliExpressService.findOrderListSimpleQuery(tokenId);
			}
		}
		
		return "";
	}
}
