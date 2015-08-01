package com.erp.service.authority;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.bean.authority.User;
import com.erp.dao.authority.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserVo queryUserVo(String username, String password) {
		User user = userDao.getUser(username, password);
		if (user != null) {
			UserVo userVo = new UserVo();
			userVo.setId(user.getId());
			userVo.setUsername(user.getUsername());
			userVo.setLoginTime(new Date());
			return userVo;
		} else {
			return null;
		}
	}
}
