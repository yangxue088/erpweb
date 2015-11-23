package com.erp.dao.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.erp.bean.authority.Menu;

public class MenuDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Menu> getMenus(List<String> ids){
		return null;
	}
}
