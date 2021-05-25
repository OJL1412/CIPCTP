package com.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.model.News;
import com.service.NewsService;


/**
 * Servlet implementation class NewsManagerServlet
 */
@WebServlet("/NewsManagerServlet")
public class NewsManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NewsService ns = new NewsService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession();
		String content = request.getParameter("content");
		/*
		if("query".equals(operate))
		{
			List<News> newslist = ns.queryAll(content);
			
			session.setAttribute("newslist", newslist);
			
			response.sendRedirect("admin/News/index.jsp");
			
		}else 
			*/
		if("delete".equals(operate)){
			int id = Integer.parseInt(request.getParameter("id"));
			
			String msg = ns.delNews(id);
			
			if("ok".equals(msg))
			{
				//删除成功
				response.sendRedirect("NewsManagerServlet?operate=showpage&page=1");
				
			}else{
				News news = ns.queryNewsById(id);
				session.setAttribute("news", news);
				response.sendRedirect("admin/News/index.jsp");
			}
			
		}else if("queryId".equals(operate)){
			int id = Integer.parseInt(request.getParameter("id"));
			
			News news = ns.queryNewsById(id);
			
			if(news != null) {
				session.setAttribute("news", news);
				response.sendRedirect("admin/News/edit.jsp");
			}else {
				response.sendRedirect("error.jsp");
			}
			
			
			
		}else if("showpage".equals(operate)){
			
			String pageNum = request.getParameter("page");
			int page = 1 ; 
			
			if(pageNum != null){
				page = Integer.parseInt(pageNum);
			}
			
			int newsCounts = ns.getTotalPage(content, false) == -1 ? 0 : ns.getTotalPage(content, false);
			int totalPage = ns.getTotalPage(content, true); // totalPage = 0 
			
			List<News> newsList = ns.queryAllByPage(page, content);
						
			session.setAttribute("newsList", newsList);
			session.setAttribute("newsCounts", newsCounts); //总记录数
			session.setAttribute("newsTotalPage", totalPage); //总页数
			session.setAttribute("newsPage", page); //当前页
			session.setAttribute("newsContent", content); //保存查询条件
			
			response.sendRedirect("admin/News/index.jsp");
			
		}
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int state = Integer.parseInt(request.getParameter("state"));
		String content  =request.getParameter("content");
		String img = request.getParameter("img");
		int ck = Integer.parseInt(request.getParameter("ck")); 
		String msg = null;
		
		if("preserve".equals(operate))
		{
			msg = ns.addNews(title, author, state, content, img, ck);
		}else {
				int id = Integer.parseInt(request.getParameter("id"));
				msg = ns.mergeNews(id, title, author, state, content, img, ck);
		}
		
		if("ok".equals(msg))
		{
			response.sendRedirect("NewsManagerServlet?operate=showpage&page=1");
		}else {
			response.sendRedirect("error.jsp");
		}
	}

}
