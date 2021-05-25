package com.service;

import java.util.Date;
import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.dao.INewsDao;
import com.impl.INewsDaoImpl;
import com.model.News;

public class NewsService {
	private INewsDao nao = new INewsDaoImpl();
	private final int ROWS_NUM = 5 ; 
	
	public String addNews(String title, String author, int state, String content, String img, int ck)
	{
		String msg = null;
		if(state > 2 || StringUtils.isEmptyOrWhitespaceOnly(title) || StringUtils.isEmptyOrWhitespaceOnly(author) || StringUtils.isEmptyOrWhitespaceOnly(content))
		{
				msg = "error";
			
		}else {
				News n = new News();
				
				n.setTitle(title);
				n.setAuthor(author);
				n.setState(state);
				n.setContent(content);
				n.setImg(img);
				n.setPubdate(new Date());
				n.setCk(ck);
				
				try {
					nao.addNews(n);
					msg="ok";
					
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}		
			}
		return msg;
	}
	
	
	public String delNews(int id)
	{
		String msg = "";
		
		if(id<0)
		{
			System.out.println("参数有误!");
			msg = "error";
		}else {
			News n = null;
			
			try {
				n = nao.queryNewsById(id);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			if(n == null)
			{
				msg = "id不存在";
			}else {
					try {
						nao.delNews(id);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				msg = "ok";
			}
		}
		return msg;
	}
	
	
	public String mergeNews(int id, String title, String author, int state, String content, String img, int ck)
	{
		String msg = null;
		if(id < 0 || StringUtils.isEmptyOrWhitespaceOnly(title) || StringUtils.isEmptyOrWhitespaceOnly(author) || StringUtils.isEmptyOrWhitespaceOnly(content))
		{
			System.out.println("参数有误!");
			msg = "error";
		}else {
			News n = null;
			
			try {
				n = nao.queryNewsById(id);
				msg = "ok";
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			if (n == null) {
				return "id不存在";
			}
			
			n.setTitle(title);
			n.setAuthor(author);
			n.setState(state);
			n.setContent(content);
			n.setImg(img);
			n.setPubdate(new Date());
			n.setCk(ck);
			
			try {
				nao.updNews(n);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		return msg;
	}
	
	public News queryNewsById(int id)
	{
		News n = null;
		if(id < 0)
		{
			return n;
		}
		
		try {
			n = nao.queryNewsById(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return n;
	}
	
	public List<News> queryAll(String content)
	{
		List<News> list = null;
		
		try {
			if(content == null)
			{
				list = nao.queryAll();
				}else {
					list = nao.queryNewsByContent(content);
					}
			}catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	
	
	public News queryNews(int id)
	{
		News n = null;
		
		try {
			if(id == 0)
			{
				n = nao.queryNewsByPubdateLimitOne();
				}else {
					n = nao.queryNewsById(id);
					}
			}catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
		}
		return n;
	}
	
	public int getTotalPage(String content, boolean flag)
	{
		int counts = -1;
		
		try {
			counts = nao.getTotalCount(content);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(flag)
		{
			return (int) Math.ceil(counts*1.0/ROWS_NUM);
		}else {
			return counts;
		}
	}
	
	
	public List<News> queryAllByPage(int page, String content)
	{
		int totalPage = getTotalPage(content, true);
		
		if(totalPage != 0 && page > totalPage)
		{
			page = totalPage;
		}
		
		if(page < 1)
		{
			page = 1;
		}
		
		int startIndex = (page - 1)*ROWS_NUM;
		List<News> list = null;
		try {
			list = nao.queryAllByPage(startIndex, ROWS_NUM, content);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
	

}
