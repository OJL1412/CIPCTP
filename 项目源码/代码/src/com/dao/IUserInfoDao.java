package com.dao;

import java.util.List;

import com.model.UserInfo;

public interface IUserInfoDao {
	public static final int ROWS_NUM = 3 ; 
	
	void addUserInfo(UserInfo u) throws Exception;
	
	void delUserInfo(int id) throws Exception;
	
	void updUserInfo(UserInfo u) throws Exception;
	
	List<UserInfo> queryUserInfoByPage(int startIndex, String name) throws Exception;
	
	int getTotalCounts(String name) throws Exception ; 

	UserInfo queryUserInfoById(int id) throws Exception ; 
	
	UserInfo queryUserInfoByName(String name) throws Exception ; 


}
