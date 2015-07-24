package com.erp.bean.authority;

public class Privilege {
	public final static int READ = 1 << 0;
	public final static int CREATE = 1 << 1;
	public final static int UPDATE = 1 << 2;
	public final static int DELETE = 1 << 3;

	public boolean isRead(int pris) {
		return (pris & READ) > 0;
	}
	
	public boolean isCreate(int pris){
		return (pris & CREATE) > 0;
	}
	
	public boolean isUpdate(int pris){
		return (pris & UPDATE) > 0;
	}
	
	public boolean isDelete(int pris){
		return (pris & DELETE) > 0;
	}
	
	public int flip(int pris){
		return (READ | CREATE | UPDATE | DELETE) ^ pris;
	}
}
