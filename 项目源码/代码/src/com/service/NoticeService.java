package com.service;

import java.util.Date;
import java.util.List;

import com.mysql.cj.protocol.x.Notice;
import com.mysql.cj.util.StringUtils;
import com.dao.INoticesDAO;
import com.impl.NoticesDAOImpl;
import com.model.Notices;

/**
 * ҵ���߼���
 * ��Ҫ�������ݳ־ò�ķ��� 
 * @author Administrator
 *
 */
public class NoticeService {
	
	private INoticesDAO nao = new NoticesDAOImpl();
	private final int ROWS_NUM = 3 ; 
	/**
	 * 1.��ȡ����
	 * 2.У�����
	 * 3.ҵ���߼�
	 * 4.����ֵ
	 * @param owner
	 * @param content
	 * @return
	 */
	public String addNotices(String owner , String content){
		String msg = null ; 
		/* ����ж�int���͵������Ƿ�Ϊ��? 
		 * 		eg1:String.valueOf(id) == null,��Ϊ�ж�int���͵�����id�Ƿ�Ϊ��.
		 * 		eg2:StringUtils.isEmptyOrWhitespaceOnly(name),��Ϊ�ж�String���͵�����name�Ƿ�Ϊ��.
		 * */
		
		if(StringUtils.isEmptyOrWhitespaceOnly(owner) || StringUtils.isEmptyOrWhitespaceOnly(content)){
			msg = "error";
		}else{
			Notices n = new Notices() ; 
			n.setOwner(owner);
			n.setContent(content);
			n.setShowTime(new Date());
			try {
				nao.addNotice(n);
				msg = "ok" ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	public String delNotices(int id){
		String msg = "";
		if(id < 0){
			msg = "error" ;
		}else{
			try {
				//��ѯ id �Ƿ����
				Notices n = nao.queryNoticeById(id);
				if(n == null){
					//id������
					msg = "id ������" ;
				}else{
					//ɾ��
					nao.delNotice(id);
					msg = "ok" ;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	public String mergeNotices(int id , String owner , String content){
		String msg = null ; 
		if(StringUtils.isEmptyOrWhitespaceOnly(owner) || StringUtils.isEmptyOrWhitespaceOnly(content)){
			msg = "error";
		}else{
			Notices n = new Notices(id , owner , content , new Date()) ;
			try {
				nao.updNotice(n);
				msg = "ok" ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	/**
	 * 1. ��ѯ���е� �� 
	 * 2. ����������ģ����ѯ �� 
	 * @return
	 */
	public List<Notices> queryAll(String name){
		List<Notices> list = null ; 
		try {
			if(name == null){
				list = nao.queryAll();
			}else{
				list = nao.queryNoticesByName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
	
	/**
	 * 1. ����id��ѯ�����ġ� 
	 * 2. Ĭ�ϲ�ѯ����ʱ�����µĹ���
	 * @return
	 */
	public Notices queryNotice(int id){
		Notices n = null ; 
		try {
			if(id == 0){
				//Ĭ�ϲ�ѯ����ʱ�����µĹ���
				n = nao.queryNoticeByShowTimeLimitOne();
			}else{
				n = nao.queryNoticeById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n ; 
	}
	
	/**
	 * ��ȡ��ҳ��
	 * @param content
	 * @return
	 */
	public int getTotalPage(String content){
		int totalCount = -1 ; 
		try {
			totalCount = nao.getTotalCount(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int)Math.ceil(totalCount * 1.0 / ROWS_NUM); 
	}
	
	
	/**
	 * ��ҳ��ѯ����
	 * @param page
	 * @param content
	 * @return
	 */
	public List<Notices> queryAllByPage(int page , String content){
		int totalPage = getTotalPage(content);
		if(page < 0 || page > totalPage){
			System.err.println("��������");
			return null ; 
		}

		int startIndex = (page -1) * ROWS_NUM ;
		List<Notices> list = null ; 
		try {
			list = nao.queryAllByPage(startIndex, ROWS_NUM, content); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
	
	
}
