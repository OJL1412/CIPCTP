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
 * ���Ʋ�
 * ���Ʋ���Ҫ����ҵ���߼���
 */
@WebServlet("/NoticesManagerServlet")
public class NoticesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private NoticeService ns = new NoticeService() ; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ��δ�߽��ض���ʱ,request���ڴ�form���л�ȡname����Ϊoperate�ı�ǩ���value�µ�ֵ.
		 * �����ض���������ת��doGetʱ,ruquest��ȡ����url�еĲ���ֵ,��˲Ż���NoticesManagerServlet?operate=query
		 * �Ĵ���.
		 *  */
		String operate = request.getParameter("operate");
		HttpSession session = request.getSession() ;
		String content = request.getParameter("content"); //null
		if("query".equals(operate)){
			//��ȡ�û����������
			
			List<Notices> noticesList = ns.queryAll(content);
			//���뵽session��
			session.setAttribute("noticesList", noticesList);
			//��תҳ��
			response.sendRedirect("admin/Notices/index.jsp");
		}else if("delete".equals(operate)){
			//����id����ɾ��
			int id = Integer.parseInt(request.getParameter("id"));
			String msg = ns.delNotices(id);
			if("ok".equals(msg)){
				//ɾ���ɹ�
				/* ΪʲôҪ�ض��򵽵�ǰҳ��,������index.jsp? 
				 * 		��Ϊ�������ض���index.jspҳ��,������ʾ�Ļ�����û�޸�֮ǰ������,
				 * 		��������ҳ����ʾ���޸ĺ������,�������Ҫ��NoticesManagerServlet���¼���һ���������.
				 * 		�������Ҫ�ض��򵽵�ǰҳ��.
				 * ע����operate=query,����һ������Ϊquery����Ϊ��ִ��if("query".equals(operate)){}��δ���
				 * �����޸ĺ����ݵĲ�ѯ,����ת��admin/Notices/index.jsp����,ʵ��ҳ�����ݵĸ���.
				 * */
				response.sendRedirect("NoticesManagerServlet?operate=query");
			}else{
				//ɾ��ʧ��
				/* PrintWriter out = response.getWriter()Ϊ��������ͻ��˷������ݵķ���,������Ҫʹ��out.print()��
				 * ������������ʾ���� */
				PrintWriter out = response.getWriter();
				out.print("ɾ��ʧ��");
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
			//��ȡ�ܼ�¼��
			int counts = ns.queryAll(content).size() ;
			//��ȡ��ҳ��  totalPage    ��ǰҳpage
			
			session.setAttribute("noticesList", noticesList);
			session.setAttribute("ntCounts", counts); //�ܼ�¼��
			session.setAttribute("ntTotalPage", totalPage); //��ҳ��
			session.setAttribute("ntPage", page); //��ǰҳ
			session.setAttribute("ntContent", content); //�����ѯ����
			
			response.sendRedirect("admin/Notices/index.jsp");
		}
	}

	/**
	 * �ύ����ʱ����ʾ��ָ����method = post ������£� �ſ���ִ��doPost����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		String owner = request.getParameter("owner");
		String content = request.getParameter("content");
		String msg = null ; 
		if("add".equals(operate)){
			//������Ҫ��������   filter
			msg = ns.addNotices(owner, content);
		}else{
			//ִ�и��µĴ���
			int id = Integer.parseInt(request.getParameter("id"));
			msg = ns.mergeNotices(id,owner,content) ; 
		}
		if("ok".equals(msg)){
			//��ӳɹ�   ��ת��
			response.sendRedirect("NoticesManagerServlet?operate=showpage");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
