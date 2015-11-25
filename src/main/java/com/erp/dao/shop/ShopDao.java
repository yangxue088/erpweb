package com.erp.dao.shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.erp.service.aliexpress.AliToken;
import com.erp.service.shop.Shop;

@Repository
public class ShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TokenDao tokenDao;

	public List<Shop> listShop() {
		List<Shop> shops = jdbcTemplate.query("select * from shop", new ShopMapper());

		for(Shop shop : shops){
			if(Shop.TYPE_ALIEXPRESS.equals(shop.getType())){
				AliToken aliToken = tokenDao.getAliToken(shop.getTokenId());
				shop.setExpireTime(aliToken.getRefreshTokenTimeout());
				shop.setAuthTime(aliToken.getUpdateTime());
			}
		}
		
		return shops;
	}

	public Shop getShop(int id) {
		return jdbcTemplate.queryForObject("select * from shop where id=?", new Object[] { id }, new ShopMapper());
	}

	public Shop getShop(String name) {
		List<Shop> shops = jdbcTemplate.query("select * from shop where name=?", new Object[] { name }, new ShopMapper());

		Shop shop = null;
		if (shops.size() > 0) {
			shop = shops.get(0);
		}
		return shop;
	}

	public void createShop(String type, String name, int token_id) {
		jdbcTemplate.update("insert into shop(type, name, token_id, create_time, update_time) values(?, ?, ?, null, null)", type, name, token_id);
	}

	public void deleteShop(int id) {
		jdbcTemplate.update("delete from shop where id=?", id);
	}

	public void editShop(int id, String name) {
		jdbcTemplate.update("update shop set name=? where id=?", name, id);
	}

	private class ShopMapper implements RowMapper<Shop> {

		public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shop shop = new Shop();
			shop.setId(rs.getInt("id"));
			shop.setType(rs.getString("type"));
			shop.setName(rs.getString("name"));
			shop.setTokenId(rs.getInt("token_id"));

			return shop;
		}

	}

}
