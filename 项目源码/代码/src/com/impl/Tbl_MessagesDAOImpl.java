package com.impl;

import java.sql.ResultSet;
import java.util.List;
import com.dao.Tbl_MessagesDAO;
import com.model.Tbl_Messages;
import com.util.DBHelper;
import com.util.GetList;

public class Tbl_MessagesDAOImpl implements Tbl_MessagesDAO {

	String str = "name,content,phone,mtime";
	@Override
	public void addMessage(Tbl_Messages m) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "insert into Tbl_Message("+ str +") values(?,?,?,?)";
		DBHelper.executeUpdate(sql, m.getName(),m.getContent(),m.getPhone(),m.getMtime());
	}

	@Override
	public void delMessage(int id) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "delete from Tbl_Messages where id = " + id;
		DBHelper.executeUpdate(sql);

	}

	@Override
	public void updMessage(Tbl_Messages m) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "update Tbl_Messages set name = ?, content = ?, phone = ?, mtime = ?";
		DBHelper.executeUpdate(sql, m.getName(),m.getContent(),m.getPhone(),m.getMtime());

	}

	@Override
	public Tbl_Messages querryById(int id) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select id," + str +"from Tbl_Messages where id = " + id;
		return GetList.getListMessages(DBHelper.executeQuery(sql)).get(0);
	}

	@Override
	public List<Tbl_Messages> querryAllByPage(int StartIndex, int rows, String content) throws Exception {
		// TODO 自动生成的方法存根
		String sql = null;
		if(content != null) {
			sql = "select id," + str + "from Tbl_Messages where content like '% " + content + "%' ";
		}else {
			sql = "select id," + str + "from Tbl_Messages order by mtime decs limit" + StartIndex + "," + rows;
		}
		return GetList.getListMessages(DBHelper.executeQuery(sql));
	}

	@Override
	public int getTotalCount(String content) {
		// TODO 自动生成的方法存根
		String sql = "select count(*) as total from Tbl_Messages";
		if(content != null) {
			sql += "where content like '%" + content + "%'";
		}
		ResultSet rs = null; 
		int total = 0;
		try {
			rs = DBHelper.executeQuery(sql);
			rs.next();
			total = rs.getInt("total");
			rs.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return total;
	}

}
