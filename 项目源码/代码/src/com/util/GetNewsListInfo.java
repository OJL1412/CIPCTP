package com.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.News;

public class GetNewsListInfo {
	public static List<News> getListInfo(ResultSet rs) throws Exception{
		List<News> list = new ArrayList<News>() ;
		
		while(rs.next()){
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			int state = rs.getInt("state");
			String content = rs.getString("content");
			String img = rs.getString("img");
			Date pubdate = rs.getDate("pubdate");
			int ck = rs.getInt("ck");
			
			News n = new News(id, title, author, state, content, img, pubdate, ck);
			
			list.add(n);
		}
		rs.close();
		return list ; 
	}
	
	public static News getNewsInfo(ResultSet rs) throws Exception{
		//传入一个结果集，返回一个List集合 。 
		List<News> list = getListInfo(rs);
		return list.size() > 0 ? list.get(0) : null ; 
	}

}
