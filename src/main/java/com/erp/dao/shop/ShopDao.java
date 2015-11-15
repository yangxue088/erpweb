package com.erp.dao.shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.erp.service.shop.Shop;

@Repository
public class ShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Shop> listShop() {
		return jdbcTemplate.query("select * from shop", new RowMapper<Shop>() {

			public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
				Shop shop = new Shop();
				shop.setId(rs.getString("id"));
				shop.setShop_type(rs.getString("type"));
				shop.setShop_name(rs.getString("name"));
				shop.setAccount_id(rs.getString("account_id"));

				Timestamp timestamp = rs.getTimestamp("refresh_token_timeout");
				shop.setValidity(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp));
				return shop;
			}

		});
	}

	public void createShop(String type, String name, String account_id, String access_token, String refresh_token, String refresh_token_timeout) {
		try {
			Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyyMMddHHmmssSSSZ").parse(refresh_token_timeout).getTime());
			jdbcTemplate.update("insert into shop(type, name, account_id, access_token, refresh_token, refresh_token_timeout, create_time, update_time) values(?,?,?,?,?,?,?,?)", type, name, account_id, access_token, refresh_token, timestamp, null, null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void deleteShop(String id) {
		jdbcTemplate.update("delete from shop where id=?", id);
	}

	public void editShop(String id, String name) {
		jdbcTemplate.update("update shop set name=? where id=?", name, id);
	}

}
