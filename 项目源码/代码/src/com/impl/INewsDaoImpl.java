package com.impl;

import java.sql.ResultSet;

import java.util.Date;
import java.util.List;
import com.dao.INewsDao;
import com.model.News;
import com.util.DBHelper;
import com.util.GetNewsListInfo;

public class INewsDaoImpl implements INewsDao {
	private final String SQL = "select id, title, author, state, content, img, pubdate, ck from tbl_news ";

	@Override
	public void addNews(News n) throws Exception {
		String sql = "insert into tbl_news(title, author, state, content, img, pubdate, ck) values(?, ?, ?, ?, ?, ?, ?)";
		DBHelper.executeUpdate(sql, n.getTitle(), n.getAuthor(), n.getState(), n.getContent(), n.getImg(), n.getPubdate(), n.getCk());

	}

	@Override
	public void delNews(int id) throws Exception {
		String sql  = "delete from tbl_news where id="+id;
		DBHelper.executeUpdate(sql);

	}

	@Override
	public void updNews(News n) throws Exception {
		String sql = "update tbl_news set title = ?, author = ?, state = ?, content = ?, img = ?, pubdate = ?, ck = ? where id = ?";
		DBHelper.executeUpdate(sql, n.getTitle(), n.getAuthor(), n.getState(), n.getContent(), n.getImg(), n.getPubdate(), n.getCk(), n.getId());

	}

	@Override
	public List<News> queryAll() throws Exception {
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(SQL));
	}

	@Override
	public News queryNewsById(int id) throws Exception {
		String sql = this.SQL + "where id="+id;
		return GetNewsListInfo.getNewsInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public List<News> queryNewsByTitle(String title) throws Exception {
		String sql = this.SQL + "where title like '%"+title+"%'";
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(sql));
	}
	
	@Override
	public List<News> queryNewsByAuthor(String author) throws Exception {
		String sql = this.SQL +"where author like '%"+author+"%'";
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(sql));
	}
	
	@Override
	public List<News> queryNewsByContent(String content) throws Exception {
		String sql = this.SQL + "where content like '%"+content+"%'";
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public List<News> queryNewsByPubdate(Date pubdate) throws Exception {
		String sql = this.SQL + "where pubdate like '%"+pubdate+"%'";
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public List<News> queryAllByPage(int startIndex, int rows, String content) throws Exception {
		String sql = this.SQL;
		if(content != null)
		{
			sql += "where content like '%"+content+"%'";
		}
		sql +="order by pubdate desc limit " + startIndex + "," + rows;
		return GetNewsListInfo.getListInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public int getTotalCount(String content) throws Exception {
		String sql = "select count(*) as total from tbl_news";
		if(content != null)
		{
			sql += " where content like '%"+content+"%'";
		}
		
		ResultSet rs = DBHelper.executeQuery(sql);
		rs.next();
		int total = rs.getInt("total");
		rs.close();
		return total;
	}

	@Override
	public News queryNewsByPubdateLimitOne() throws Exception {
		String sql = this.SQL +"order by pubdate desc limit 1";
		return GetNewsListInfo.getNewsInfo(DBHelper.executeQuery(sql));
	}

}
