package com.erp.dao.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.erp.bean.authority.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String username, String password) {
		SqlRowSet rs = jdbcTemplate
				.queryForRowSet(
						"select id, username, password, create_time, update_time from user where username=? and password=password(?)",
						new Object[] { username, password });
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(rs.getString("username"));
			return user;
		}
		return null;
	}

	public List<User> getUsers() {
		return null;
	}

	public void addUser(User user) {
	}

	public void delUser(String id) {

	}

	public void uptUser(User user) {

	}

}
