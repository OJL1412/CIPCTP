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

import com.model.Opus;
import com.model.OpusInfo;
import com.service.OpusService;

/**
  * 控制层
  * 控制层需要调用业务逻辑层
 * @author hasee
 *
 */
@WebServlet("/OpusManagerServlet")
public class OpusManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OpusService os = new OpusService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		
		if ("query".equals(operate)) {
			//获取用户输入的内容
			List<OpusInfo> opusList = os.queryAll(name);
			
			
			session.setAttribute("opusList", opusList);
			response.sendRedirect("admin/Opus/index.jsp");
		} else if ("delete".equals(operate)) {
			//根据id进行删除
			int id = Integer.parseInt(request.getParameter("id"));
			
			String msg = os.delOpus(id);
			if ("ok".equals(msg)) {
				//删除成功
				response.sendRedirect("OpusManagerServlet?operate=showpage&name=" + name);
			} else {
				//删除失败
				PrintWriter out = response.getWriter();
				out.print("删除失败");
			};
			
			
			
		} else if ("queryId".equals(operate)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Opus opus = os.queryOpus(id);
			session.setAttribute("opus", opus);
			response.sendRedirect("admin/Opus/edit.jsp");
		} else if ("showpage".equals(operate)) {
			
			String pageNum = request.getParameter("page");
			int page = 1;
			if (pageNum != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			int totalPage = os.getTotalPage(name); // totalPage = 0
			if (page < 1) {
				page = 1;
			}
			
			if (page >= totalPage) {
				page = totalPage;  // page = 0 
			}
			
			page = page == 0 ? 1 : page;
			
			List<OpusInfo> opusList = os.queryAllByPage(page, name);
			//获取总记录数
			int counts = os.queryAll(name).size();
			//获取总页数  totalPage    当前页page
			
			session.setAttribute("opusList", opusList);
			session.setAttribute("ntCounts", counts); //总记录数
			session.setAttribute("ntTotalPage", totalPage); //总页数
			session.setAttribute("ntPage", page); //当前页
			session.setAttribute("ntName", name); //保存查询条件
			
			response.sendRedirect("admin/Opus/index.jsp");
			
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operate = request.getParameter("operate");
		if ("add".equals(operate)) {
			// 添加
			int id = Integer.parseInt(request.getParameter("id"));
			String author = request.getParameter("author");
			String name = request.getParameter("name");
			String img = request.getParameter("img");
			int tid = Integer.parseInt(request.getParameter("tid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			String introduce = request.getParameter("introduce");
			os.addOpus(author, name, img, tid, sid, introduce);
			
		} else {
			
			//修改
			int id = Integer.parseInt(request.getParameter("id"));
			String author = request.getParameter("author");
			String name = request.getParameter("name");
			String img = request.getParameter("img");
			int tid = Integer.parseInt(request.getParameter("tid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			String introduce = request.getParameter("introduce");
			
			//调用业务逻辑层方法
			os.mergeOpus(id, author, name, img, tid, sid, introduce);
	
		}
		//跳转页面
		
		response.sendRedirect("OpusManagerServlet?operate=showpage");
	}

}
