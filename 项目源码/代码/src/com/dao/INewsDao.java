package com.dao;

import java.util.Date;

import java.util.List;

import com.model.News;


public interface INewsDao {
	void addNews(News n) throws Exception;
	
	void delNews(int id) throws Exception;
	
	void updNews(News n) throws Exception;
	
	List<News> queryAll() throws Exception;
	
	News queryNewsById(int id) throws Exception;
	
	List<News> queryNewsByTitle(String title) throws Exception;
	
	List<News> queryNewsByAuthor(String author) throws Exception;
	
	List<News> queryNewsByContent(String content) throws Exception;
	
	List<News> queryNewsByPubdate(Date pubdate) throws Exception;
	
	News queryNewsByPubdateLimitOne() throws Exception;
	
	List<News> queryAllByPage(int startIndex, int rows, String content) throws Exception;
	
	int getTotalCount(String content) throws Exception;

}
