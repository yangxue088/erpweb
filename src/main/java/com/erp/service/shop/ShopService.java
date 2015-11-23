package com.erp.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.shop.ShopDao;

@Service
public class ShopService {

	@Autowired
	private ShopDao shopDao;

	public List<Shop> listShop() {
		return shopDao.listShop();
	}

	public void deleteShop(String id) {
		shopDao.deleteShop(id);
	}

	public void editShop(String id, String name) {
		shopDao.editShop(id, name);
	}

}
