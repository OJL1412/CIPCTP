package com.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;
import com.dao.INoticesDAO;
import com.model.Notices;
import com.util.DBHelper;

/**
 * 数据持久层
 * @author Administrator
 *
 */
public class NoticesDAOImpl implements INoticesDAO {

	private final String SQL = "select id, owner , content , show_time from tbl_notices ";
	
	@Override
	public void addNotice(Notices n) throws Exception {
		String sql  = "insert into tbl_notices (owner, content , show_time) values (?,?,?)";
		DBHelper.executeUpdate(sql , n.getOwner(), n.getContent(),n.getShowTime());
	}

	@Override
	public void delNotice(int id) throws Exception {
		String sql = "delete from tbl_notices where id = " + id;
		DBHelper.executeUpdate(sql);
	}

	@Override
	public void updNotice(Notices n) throws Exception {
		String sql  = "update tbl_notices set owner = ? , content = ? , show_time = ?  where id = ?";
		DBHelper.executeUpdate(sql, n.getOwner() , n.getContent(), n.getShowTime() , n.getId());
	}

	private List<Notices> getListInfo(ResultSet rs) throws Exception{
		List<Notices> list = new ArrayList<Notices>() ;
		while(rs.next()){
			int id = rs.getInt("id");
			String owner = rs.getString("owner");
			String content = rs.getString("content");
			/*
			 * 1、java.sql.Date是针对SQL语句使用的，它只包含日期而没有时间部分,一般在读写数据库的时候用,PreparedStament的setDate
			 * ()的参数和ResultSet的getDate()方法的都是java.sql.Date
			 * 2、java.util.Date是在除了SQL语句的情况下面使用,一般是日常日期字段.
			 */
			Date showTime = rs.getDate("show_time");
			Notices n = new Notices(id, owner, content, showTime);
			list.add(n);
		}
		rs.close();
		return list ; 
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Notices> queryAll() throws Exception {
		ResultSet rs = DBHelper.executeQuery(SQL);
		return getListInfo(rs);
	}
	
	/**
	 * 按照名称来模糊查询
	 */
	@Override
	public List<Notices> queryNoticesByName(String name) throws Exception {
		String sql  = this.SQL + " where content like '%"+name+"%'" ;
		return getListInfo(DBHelper.executeQuery(sql));
	}

	/**
	 * 根据结果集获取单个对象
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Notices getNoticesInfo(ResultSet rs) throws Exception{
		//传入一个结果集，返回一个List集合 。 
		List<Notices> list = getListInfo(rs);
		return list.size() > 0 ? list.get(0) : null ; 
	}
	
	@Override
	public Notices queryNoticeById(int id) throws Exception {
		String sql = this.SQL + " where id = " + id ; 
		return getNoticesInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public Notices queryNoticeByShowTimeLimitOne() throws Exception {
		String sql = this.SQL + " order by show_time desc limit 1" ;
		return getNoticesInfo(DBHelper.executeQuery(sql));
	}

	/**
	 * 分页查询指定的数据
	 */
	@Override
	public List<Notices> queryAllByPage(int startIndex, int rows, String content) throws Exception {
		String sql  = this.SQL;
		if(content != null){
			sql += " where content like '%"+content+"%' " ;
		}
		sql += " order by show_time desc limit " + startIndex +" , "  + rows ; 
		return getListInfo(DBHelper.executeQuery(sql)); 
	}

	/**
	 * 获取总的数据量
	 */
	@Override
	public int getTotalCount(String content) throws Exception {
		/* sql语句中的count(*),表示查询表中所有记录的总个数.如此处表示的是查询tbl_notices这个表中所有记录的总个数 */
		String sql = "select count(*) as total from tbl_notices " ;
		if(content != null){
			sql += " where content like '%"+content+"%' " ;
		}
		ResultSet rs = DBHelper.executeQuery(sql);
		/* 为什么要指针向下移动一行? 
		 * 		因为指针是默认指向第一行的,而第一行一般来说没有数据,因此要想取到结果集中的数据,就需要使指针向下移动一行.*/
		rs.next() ;  //指针向下移动一行
		int total = rs.getInt("total");
		rs.close();   // too many connection  太多的连接  数据库连接池  框架技术 
		return total;
	}
}
