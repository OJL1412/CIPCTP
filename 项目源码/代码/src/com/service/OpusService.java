package com.service;

import java.util.Date;
import java.util.List;

import com.dao.IOpusDAO;
import com.impl.OpusDAOImpl;
import com.model.Opus;
import com.model.OpusInfo;
import com.mysql.cj.util.StringUtils;

/**
  * ҵ���߼���
  * ��Ҫ�������ݳ־ò�ķ���
 * @author hasee
 *
 */
public class OpusService {
	
	private IOpusDAO os = new OpusDAOImpl();
	private final int ROWS_NUM = 3 ; 
	
	/**
	 * 1.��ȡ���� 2.У����� 3.ҵ���߼� 4.����ֵ
	 * @param author
	 * @param name
	 * @param img
	 * @param tid
	 * @param sid
	 * @param introduce
	 * @return
	 */
	
	public String addOpus(String author, String name, String img, int tid, int sid, String introduce) {
		Opus o = new Opus();
		o.setAuthor(author);
		o.setName(name);
		o.setUtime(new Date());
		o.setImg(img);
		o.setCk(0);
		o.setTid(tid);
		o.setSid(sid);
		o.setIntroduce(introduce);
		try {
			os.addOpus(o);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	
	public String delOpus(int id) {
		String msg = "";
		if (id < 0) {
			msg = "error";
		} else {
			try {
				//��ѯ id �Ƿ����
				Opus o = os.queryOpusById(id);
				if (o == null) {
					//id������
					msg = "id ������" ;
				} else {
					//ɾ��
					os.delOpus(id);
					msg = "ok";
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	public String mergeOpus(int id, String author, String name, String img, int tid, int sid, String introduce) {
		Opus o = null;
		try {
			o = os.queryOpusById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		o.setAuthor(author);
		o.setName(name);
		o.setImg(img);
		o.setTid(tid);
		o.setSid(sid);
		o.setUtime(new Date());
		o.setIntroduce(introduce);
		try {
			os.updOpus(o);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	/**
	 * 1. ��ѯ���е� �� 
	 * 2. ����������ģ����ѯ ��
	 * @param name
	 * @return
	 */
	public List<OpusInfo> queryAll(String name) {
		List<OpusInfo> list = null;
		try {
			if (name == null) {
				list = os.queryAll();
			} else {
				list = os.queryAllByName(name);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Opus queryOpus(int id) {
		Opus o = null;
		try {
			o = os.queryOpusById(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * ��ȡ��ҳ��
	 * @param content
	 * @return
	 */
	public int getTotalPage(String content) {
		int totalCount = -1;
		try {
			totalCount = os.getTotalCount(content);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return (int)Math.ceil(totalCount * 1.0 / ROWS_NUM);
	}
	
	public List<OpusInfo> queryAllByPage(int page, String content) {
		int totalPage = getTotalPage(content);
		if (page < 0 || page > totalPage) {
			System.err.println("��������");
			return null ; 
		}
		
		int startIndex = (page - 1) * ROWS_NUM;
		List<OpusInfo> list = null;
		try {
			list = os.queryOpusAllBypage(startIndex, ROWS_NUM, content);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

