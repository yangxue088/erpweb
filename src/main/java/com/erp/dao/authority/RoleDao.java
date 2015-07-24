package com.erp.dao.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.erp.bean.authority.Role;

public class RoleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Role getRole(String id){
		return null;
	}
	
	public List<Role> getRoles(){
		return null;
	}

	public void addRole(Role role){
		
	}
	
	public void delRole(String id){
		
	}
	
	public void uptRole(Role role){
		
	}
	
}
