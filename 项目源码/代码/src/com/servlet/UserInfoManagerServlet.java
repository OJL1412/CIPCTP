package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserInfo;
import com.service.UserService;

/**
 * Servlet implementation class UserInfoManagerServlet
 */
@WebServlet("/UserInfoManagerServlet")
public class UserInfoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserService();	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession();
		PrintWriter out  = response.getWriter();
		
		String pageNum = request.getParameter("page");
		String name = request.getParameter("name");
		
		if("delete".equals(operate))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String msg = us.delUserInfo(id);
			
			if("ok".equals(msg))
			{
				response.sendRedirect("UserInfoMannagerServlet?operate=query");
			}else {
				out.print(msg);
			}
		}else if("query".equals(operate))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			UserInfo ui = us.queryUserInfoById(id);
			if(ui != null)
			{
				session.setAttribute("ui", ui);
				response.sendRedirect("admin/User/edit.jsp");
			}else{
				out.print("id不存在");
			}
		}else {
			int page = 1;
			int totalPage = us.getTotalPage(name, true);
			int totalCounts = us.getTotalPage(name, false);
			if(pageNum != null)
			{
				page = Integer.parseInt(pageNum);
			}
			
			if(page<1)
			{
				page = 1;
			}
			
			if(page>=totalPage)
			{
				page = totalPage;
			}
			
			List<UserInfo> uiList = us.queryUserInfosByPage(page, name);
			
			session.setAttribute("uiPage", page);
			session.setAttribute("uiTotalPage", totalPage);
			session.setAttribute("uitotalCounts", totalCounts);
			session.setAttribute("uiList", uiList);
			response.sendRedirect("admin/User/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String operate = request.getParameter("operate");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		int role_id = Integer.parseInt(request.getParameter("role_id"));
		String msg = null ; 
		if("add".equals(operate)){
			msg = us.addUserInfo(username, pwd, phone, role_id);
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			msg = us.updUserInfo(id, pwd, phone, role_id);
		}
		if("ok".equals(msg)){
			response.sendRedirect("UserInfoManagerServlet?operate=query");
		}else{
			out.print(msg);//在页面上输出错误信息
		}
	}
}
