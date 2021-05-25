package com.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.IOpusDAO;
import com.model.Opus;
import com.model.OpusInfo;
import com.util.DBHelper;

/**
  * 数据持久层
 * @author hasee
 *
 */
public class OpusDAOImpl implements IOpusDAO {

	private final String SQL = "select * from tbl_opus";
	
	@Override
	public void addOpus(Opus o) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "insert into tbl_Opus(author, name, utime, img, ck, tid, sid, introduce) values(?,?,?,?,?,?,?,?)";
		DBHelper.executeUpdate(sql, o.getAuthor(), o.getName(), o.getUtime(), o.getImg(), o.getCk(), o.getTid(), o.getSid(), o.getIntroduce());
	}

	@Override
	public void delOpus(int id) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "delete from tbl_Opus where id = " + id;
		DBHelper.executeUpdate(sql);
	}

	@Override
	public void updOpus(Opus o) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "update tbl_Opus set author = ?, name = ?, utime = ?, img = ?, ck = ?, tid = ?, sid = ?, introduce = ? where id = ?";
		DBHelper.executeUpdate(sql, o.getAuthor(), o.getName(), o.getUtime(), o.getImg(), o.getCk(), o.getTid(), o.getSid(), o.getIntroduce(), o.getId());
	}
	
	private List<Opus> getListInfo(ResultSet rs) throws Exception {
		List<Opus> list = new ArrayList<Opus>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String author = rs.getString("author");
			String name = rs.getString("name");
			Date utime = rs.getDate("utime");
			String img = rs.getString("img");
			int ck = rs.getInt("ck");
			int tid = rs.getInt("tid");
			int sid = rs.getInt("sid");
			String introduce = rs.getString("introduce");
			Opus o = new Opus(id, author, name, utime, img, ck, tid, sid, introduce);
			list.add(o);
		}
		rs.close();
		return list;
	}

	/**
	  * 按照编号查询
	 */
	@Override
	public Opus queryOpusById(int id) throws Exception {
		// TODO 自动生成的方法存根
		String sql = this.SQL + " where id = " + id;
		return getListInfo(DBHelper.executeQuery(sql)).get(0);
	}

	/**
	  * 分页查询指定的数据
	 */
	@Override
	public List<OpusInfo> queryOpusAllBypage(int startIndex, int rows, String content) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select id, author, name, utime, img, ck, "
				+ " (select name from tbl_types where id = tid) tname, tid, "
				+ " (select name from tbl_types where id = sid) sname, sid, introduce from tbl_opus ";
		if (content != null) {
			
			sql += " where name like '%" + content + "%'";
		}
		sql += " order by utime desc limit " + startIndex + ", " + rows;
		
		ResultSet rs = DBHelper.executeQuery(sql);
		List<OpusInfo> list = new ArrayList<OpusInfo>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String author = rs.getString("author");
			String name = rs.getString("name");
			Date utime = rs.getDate("utime");
			String img = rs.getString("img");
			int ck = rs.getInt("ck");
			int tid = rs.getInt("tid");
			int sid = rs.getInt("sid");
			String tname = rs.getString("tname");
			String sname = rs.getString("sname");
			String introduce = rs.getString("introduce");
			OpusInfo o = new OpusInfo(id, author, name, utime, img, ck, tid, sid, introduce, tname, sname);
			list.add(o);
		}
		
		rs.close();
		return list;
	}

	/**
	  * 获取总的数据量
	 */
	@Override
	public int getTotalCount(String content) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select count(*) as total from tbl_opus ";
		if (content != null) {
			sql += " where name like '%" + content + "%'";
		}
		ResultSet rs = DBHelper.executeQuery(sql);
		rs.next(); //指针向下移动一行
		int total = rs.getInt("total");
		rs.close(); // too many connection  太多的连接  数据库连接池  框架技术
		return total;
	}
	
	
	
	/**
	  * 查询所有
	 */
	@Override
	public List<OpusInfo> queryAll() throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select id, author, name, utime, img, ck, "
				+ " (select name from tbl_types where id = tid) tname, tid, "
				+ " (select name from tbl_types where id = sid) sname, sid, introduce from tbl_opus ";			
		
		ResultSet rs = DBHelper.executeQuery(sql);
		List<OpusInfo> list = new ArrayList<OpusInfo>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String author = rs.getString("author");
			String name = rs.getString("name");
			Date utime = rs.getDate("utime");
			String img = rs.getString("img");
			int ck = rs.getInt("ck");
			int tid = rs.getInt("tid");
			int sid = rs.getInt("sid");
			String tname = rs.getString("tname");
			String sname = rs.getString("sname");
			String introduce = rs.getString("introduce");
			OpusInfo o = new OpusInfo(id, author, name, utime, img, ck, tid, sid, introduce, tname, sname);
			list.add(o);
		}
		
		rs.close();
		return list;
	}
	
	public List<OpusInfo> queryAllByName(String name) throws Exception {
		// TODO 自动生成的方法存根
		String sql = "select id, author, name, utime, img, ck, "
				+ " (select name from tbl_types where id = tid) tname, tid, "
				+ " (select name from tbl_types where id = sid) sname, sid, introduce from tbl_opus "
				+ " where name like '%" + name + "%'";			
		
		ResultSet rs = DBHelper.executeQuery(sql);
		List<OpusInfo> list = new ArrayList<OpusInfo>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String author = rs.getString("author");
			name = rs.getString("name");
			Date utime = rs.getDate("utime");
			String img = rs.getString("img");
			int ck = rs.getInt("ck");
			int tid = rs.getInt("tid");
			int sid = rs.getInt("sid");
			String tname = rs.getString("tname");
			String sname = rs.getString("sname");
			String introduce = rs.getString("introduce");
			OpusInfo o = new OpusInfo(id, author, name, utime, img, ck, tid, sid, introduce, tname, sname);
			list.add(o);
		}
		
		rs.close();
		return list;
	}

}
