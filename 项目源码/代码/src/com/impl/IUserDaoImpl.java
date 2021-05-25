package com.impl;

import java.sql.ResultSet;
import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.dao.IUserInfoDao;
import com.model.UserInfo;
import com.util.DBHelper;
import com.util.GetUsersListInfo;

public class IUserDaoImpl implements IUserInfoDao {
	private final String SQL = "select * from tbl_users";

	@Override
	public void addUserInfo(UserInfo u) throws Exception {
		String sql = "insert into tbl_users(name, pwd, phone, role_id) values(?, ?, ?, ?)";
		DBHelper.executeUpdate(sql, u.getName(), u.getPwd(), u.getPhone(), u.getRole_id());
	}

	@Override
	public void delUserInfo(int id) throws Exception {
		String sql = "delete from tbl_users where id="+id;
		DBHelper.executeUpdate(sql);
	}

	@Override
	public void updUserInfo(UserInfo u) throws Exception {
		String sql = "update tbl_users set pwd = ?, phone = ?, role_id = ?, login_time = ?, update_time = ? where id = ?";
		DBHelper.executeUpdate(sql, u.getPwd(), u.getPhone(), u.getRole_id(), u.getLoginTime(), u.getUpdateTime(), u.getId());
	}

	@Override
	public List<UserInfo> queryUserInfoByPage(int startIndex, String name) throws Exception {
		String sql = this.SQL;
		if(!StringUtils.isNullOrEmpty(name))
		{
			sql += "where name like '%"+name+"%'";
		}
		sql += "limit "+startIndex+","+IUserInfoDao.ROWS_NUM;
		System.out.println(sql);
		return GetUsersListInfo.getListInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public int getTotalCounts(String name) throws Exception {
		String sql = "select count(*) totalCount from tbl_users";
		if(!StringUtils.isNullOrEmpty(name)){
			sql += " where name like '%"+name+"%' ";
		}
		ResultSet rs = DBHelper.executeQuery(sql);
		rs.next();
		int count = rs.getInt("totalCount");
		rs.close();
		return count ; 
	}

	@Override
	public UserInfo queryUserInfoById(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public UserInfo queryUserInfoByName(String name) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

}
