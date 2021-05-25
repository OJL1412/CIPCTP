package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Types;
import com.service.TypeService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TypesManagerServlet
 */
@WebServlet("/TypesManagerServlet")
public class TypesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypeService ts = new TypeService() ; 
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");//query
		HttpSession session = request.getSession() ; 
		if("query".equals(operate)){
			
			String parentId = request.getParameter("pid"); // null
			//获取的是一级分类
			List<Types> typesList = ts.queryAll(parentId == null ? 0 : Integer.parseInt(parentId));
			//json
			String param = request.getParameter("param");
			
			if(param == null){
				session.setAttribute("typesList", typesList);
				response.sendRedirect("admin/Types/index.jsp");
			}else{
				//respones 响应   {属性名:属性值}
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				//创建类的对象
				JSONObject json=new JSONObject();
				
				for(Types tp : typesList){
					json.put(tp.getId(), tp.getName());
					//[{属性名:属性值}, {属性名:属性值}, {属性名:属性值}]
				}
				//将json对象返回前端    对ajax请求的响应   返回值
				response.getWriter().print(json.toString());
			}
			
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			if("delete".equals(operate)){
				ts.delTypeById(id);
				response.sendRedirect("TypesManagerServlet?operate=query");
			}else{
				Types types = ts.qeuryTpById(id);
				session.setAttribute("types", types);
				session.setAttribute("typesList", ts.queryAll(0));
				response.sendRedirect("admin/Types/edit.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		String name = request.getParameter("name");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String str = null ;
		if("add".equals(operate)){
			str = ts.addType(name, pid);
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			str = ts.updTypes(id, name, pid);
		}
		if("ok".equals(str)){
			response.sendRedirect("TypesManagerServlet?operate=query");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
