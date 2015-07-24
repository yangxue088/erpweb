package com.erp.dao.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.erp.bean.authority.User;

public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String username, String password){
		return null;
	}
	
	public List<User> getUsers(){
		return null;
	}

	public void addUser(User user) {
	}

	public void delUser(String id) {

	}

	public void uptUser(User user) {
		
	}
	
}
