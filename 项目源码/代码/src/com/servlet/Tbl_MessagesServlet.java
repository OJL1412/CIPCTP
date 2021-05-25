package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Tbl_MessagesService;
import com.model.Tbl_Messages;

/**
 * Servlet implementation class Tbl_MessagesServlet
 */
@WebServlet("/Tbl_MessagesServlet")
public class Tbl_MessagesServlet extends HttpServlet {
	Tbl_MessagesService m = new Tbl_MessagesService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession();
		String content = request.getParameter("content");
		if("showpage".equals(operate)) {
			int page = 1 ; 
			String pageNum = request.getParameter("page");
			if(pageNum != null)
				page = Integer.parseInt(pageNum);
				int msgCounts;
				int totalPage;
				List<Tbl_Messages> messageList;
				try {
					msgCounts = m.getTotalPage(content, false) == -1 ? 0 : m.getTotalPage(content, false);
					totalPage = m.getTotalPage(content, true);
					messageList = m.querryByPage(page, content);
					session.setAttribute("messageList", messageList);
					session.setAttribute("msgCounts", msgCounts);
					session.setAttribute("msgTotalPage", totalPage); 
					session.setAttribute("msgPage", page); 
					session.setAttribute("msgContent", content); 
					response.sendRedirect("admin/Messages/index.jsp");
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			if("delete".equals(operate)){
				try {
					m.delMessage(id);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				response.sendRedirect("Tbl_MessagesServlet?operate=showpage&page=1");
			}else{
				try {
					Tbl_Messages ms = m.querryById(id);
					session.setAttribute("messages", ms);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				response.sendRedirect("admin/Tbl_Messages/edit.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String phone = request.getParameter("phone");
		Date mtime = new Date();
		String str = null ; 
		if("add".equals(operate)){
			try {
				str = m.addMessages(name, content, phone,mtime);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				str = m.updMessages(id, name, content, phone,mtime);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		if("ok".equals(str)){
			//跳转到显示页面
			response.sendRedirect("Tbl_MessagesServlet?operate=showpage&page=1");
		}else{
			PrintWriter out = response.getWriter() ; 
			out.print(str); //错误信息显示在页面上
		}
	}

	}


