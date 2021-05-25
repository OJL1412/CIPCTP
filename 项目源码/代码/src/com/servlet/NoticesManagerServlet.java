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

import com.model.Notices;
import com.service.NoticeService;

/**
 * 控制层
 * 控制层需要调用业务逻辑层
 */
@WebServlet("/NoticesManagerServlet")
public class NoticesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private NoticeService ns = new NoticeService() ; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 当未走进重定向时,request是在从form表单中获取name属性为operate的标签后的value下的值.
		 * 当是重定向重新跳转进doGet时,ruquest获取的是url中的参数值,因此才会有NoticesManagerServlet?operate=query
		 * 的存在.
		 *  */
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession() ;
		String content = request.getParameter("content"); //null
		if("query".equals(operate)){
			//获取用户输入的内容
			
			List<Notices> noticesList = ns.queryAll(content);
			//放入到session中
			session.setAttribute("noticesList", noticesList);
			//跳转页面
			response.sendRedirect("admin/Notices/index.jsp");
		}else if("delete".equals(operate)){
			//根据id进行删除
			int id = Integer.parseInt(request.getParameter("id"));
			String msg = ns.delNotices(id);
			if("ok".equals(msg)){
				//删除成功
				/* 为什么要重定向到当前页面,而不是index.jsp? 
				 * 		因为若是你重定向到index.jsp页面,那他显示的会是你没修改之前的数据,
				 * 		你若想让页面显示你修改后的数据,那你就需要让NoticesManagerServlet重新加载一遍你的数据.
				 * 		因此你需要重定向到当前页面.
				 * 注意了operate=query,返回一个参数为query就是为了执行if("query".equals(operate)){}这段代码
				 * 进行修改后数据的查询,并跳转到admin/Notices/index.jsp界面,实现页面数据的更新.
				 * */
				response.sendRedirect("NoticesManagerServlet?operate=query");
			}else{
				//删除失败
				/* PrintWriter out = response.getWriter()为服务器向客户端反馈数据的方法,最终需要使用out.print()把
				 * 返馈的数据显示出来 */
				PrintWriter out = response.getWriter();
				out.print("删除失败");
			}
		}else if("queryId".equals(operate)){
			int id = Integer.parseInt(request.getParameter("id"));
			Notices notices = ns.queryNotice(id);
			session.setAttribute("notices", notices);
			response.sendRedirect("admin/Notices/edit.jsp");
		}else if("showpage".equals(operate)){
			
			String pageNum = request.getParameter("page");
			int page = 1 ; 
			if(pageNum != null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			int totalPage = ns.getTotalPage(content); // totalPage = 0 
			if(page < 1)
				page = 1 ;
			if(page >= totalPage)
				page = totalPage ;  // page = 0 
			
			page = page == 0 ? 1 : page  ;
			
			
			List<Notices> noticesList = ns.queryAllByPage(page, content);
			//获取总记录数
			int counts = ns.queryAll(content).size() ;
			//获取总页数  totalPage    当前页page
			
			session.setAttribute("noticesList", noticesList);
			session.setAttribute("ntCounts", counts); //总记录数
			session.setAttribute("ntTotalPage", totalPage); //总页数
			session.setAttribute("ntPage", page); //当前页
			session.setAttribute("ntContent", content); //保存查询条件
			
			response.sendRedirect("admin/Notices/index.jsp");
		}
	}

	/**
	 * 提交表单的时候，显示的指定了method = post 的情况下， 才可以执行doPost方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		String owner = request.getParameter("owner");
		String content = request.getParameter("content");
		String msg = null ; 
		if("add".equals(operate)){
			//首先需要处理乱码   filter
			msg = ns.addNotices(owner, content);
		}else{
			//执行更新的代码
			int id = Integer.parseInt(request.getParameter("id"));
			msg = ns.mergeNotices(id,owner,content) ; 
		}
		if("ok".equals(msg)){
			//添加成功   跳转到
			response.sendRedirect("NoticesManagerServlet?operate=showpage");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
