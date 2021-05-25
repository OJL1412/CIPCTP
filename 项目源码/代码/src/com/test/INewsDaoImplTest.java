package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.dao.INewsDao;
import com.impl.INewsDaoImpl;
import com.model.News;

class INewsDaoImplTest {
	private INewsDao indao;
	
	@Before
	public void init()
	{
		indao = new INewsDaoImpl();
	}

	@Test
	void testAddNews() {
		News n = new News(); 
		
		n.setId(1);
		n.setTitle("湖人十年后重返西决");
		n.setAuthor("腾讯网");
		n.setState(2);
		n.setContent("近日.......");
		n.setImg("Images\1.jpg");
		n.setPubdate(new Date());
		n.setCk(123456);
		
		try {
			indao.addNews(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDelNews() {
		try {
			indao.delNews(2);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testUpdNews() {
		News n = new News();
		
		n.setId(2);
		n.setTitle("快船延五十年不进西决的魔咒");
		n.setAuthor("腾讯网");
		n.setState(2);
		n.setContent("昨日.......");
		n.setImg("Images\nba1.jpg");
		n.setPubdate(new Date());
		n.setCk(123456);
		
		try {
			indao.updNews(n);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testQueryAll() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryAll();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(News n : list)
		{
			System.out.println(n);
		}
	}

	@Test
	void testQueryNewsById() {
		News n = new News();
		
		try {
			n = indao.queryNewsById(1);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println(n);
	}

	@Test
	void testQueryNewsByTitle() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryNewsByTitle("互动素数");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(News n : list) 
		{
			System.out.println(n);
		}
	}

	@Test
	void testQueryNewsByAuthor() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryNewsByAuthor("腾讯网");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(News n : list)
		{
			System.out.println(n);
		}
	}

	@Test
	void testQueryNewsByContent() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryNewsByContent("近日......");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(News n : list)
		{
			System.out.println(n);
		}
	}

	@Test
	void testQueryNewsByPubdate() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryNewsByPubdate(new Date());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(News n : list)
		{
			System.out.println(n);
		}
	}

	@Test
	void testQueryAllByPage() {
		List<News> list = new ArrayList<News>();
		
		try {
			list = indao.queryAllByPage(1, 3, "hdgshgdsh");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		for(News n : list)
		{
			System.out.println(n);
		}
	}

	@Test
	void testGetTotalCount() {
		int total = 0;
		try {
			total = indao.getTotalCount("123");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println(total);
	}

	@Test
	void testQueryNewsByPubdateLimitOne() {
		News n = new News();
		
		try {
			n = indao.queryNewsByPubdateLimitOne();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println(n);
	}

}

