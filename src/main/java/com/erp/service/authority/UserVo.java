package com.erp.service.authority;

import java.util.Date;

import com.erp.bean.authority.User;

public class UserVo extends User {

	protected Date loginTime;

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", username=" + username + ", password="
				+ password + ", loginTime=" + loginTime + "]";
	}

}
