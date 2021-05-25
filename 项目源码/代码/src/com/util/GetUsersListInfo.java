package com.util;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.UserInfo;

public class GetUsersListInfo {
	public static List<UserInfo> getListInfo(ResultSet rs) throws Exception{
		List<UserInfo> list = new ArrayList<UserInfo>() ; 
		while(rs.next()){
			int id  = rs.getInt("id");
			String userName = rs.getString("username");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			int role_id = rs.getInt("role_id");
			Date loginTime = rs.getDate("login_time");
			Date createTime = rs.getDate("create_time");
			Date updateTime = rs.getDate("update_time");
			UserInfo u = new UserInfo(createTime, updateTime, id, userName, pwd, phone, role_id, loginTime);
			list.add(u);
		}
		return list ; 
	}
	
	public static UserInfo getUsersInfo(ResultSet rs) throws Exception{
		//传入一个结果集，返回一个List集合 。 
		List<UserInfo> list = getListInfo(rs);
		return list.size() > 0 ? list.get(0) : null ; 
	}

}
