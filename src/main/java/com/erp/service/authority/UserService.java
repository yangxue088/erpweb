package com.erp.service.authority;

import org.springframework.beans.factory.annotation.Autowired;

import com.erp.bean.authority.User;
import com.erp.dao.authority.UserDao;

public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserVo queryUserVo(String username, String password){
		return null;
	}
}
