package com.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ITypesDAO;
import com.model.Types;
import com.util.DBHelper;

public class TypesDAOImpl implements ITypesDAO {

	private final String SQL = "select id , name , parent_id from tbl_types ";
	
	@Override
	public void addType(Types n) throws Exception {
		String sql = "insert into tbl_types (name , parent_id) values (?,?)";
		DBHelper.executeUpdate(sql, n.getName() , n.getParentId());
	}

	@Override
	public void delType(int id) throws Exception {
		String sql = "delete from tbl_types where id = " + id ;
		DBHelper.executeUpdate(sql);
	}

	@Override
	public void updType(Types n) throws Exception {
		String sql = "update tbl_types set name = ? , parent_id = ? where id = ?";
		DBHelper.executeUpdate(sql, n.getName(), n.getParentId(), n.getId());
	}
	
	private List<Types> getListInfo(ResultSet rs) throws Exception{
		List<Types> list = new ArrayList<Types>() ; 
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int parentId = rs.getInt("parent_id");
			Types t = new Types(id, name, parentId);
			list.add(t);
		}
		return list ;  
	}

	@Override
	public Types queryTypeById(int id) throws Exception {
		String sql = this.SQL + " where id = " + id ; 
		return getListInfo(DBHelper.executeQuery(sql)).get(0);
	}

	@Override
	public List<Types> queryAll(int pid) throws Exception {
		String sql = this.SQL + " where parent_id = " + pid ; 
		return getListInfo(DBHelper.executeQuery(sql));
	}

}
