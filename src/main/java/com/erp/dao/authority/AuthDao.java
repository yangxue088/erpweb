package com.erp.dao.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addUser2Role(String userid, String roleid){
		
	}
	
	public void addMenu2Role(String menuid, String roleid, int pris){
		
	}
}
