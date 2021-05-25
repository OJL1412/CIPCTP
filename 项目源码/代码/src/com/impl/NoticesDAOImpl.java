package com.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.xdevapi.DbDoc;
import com.dao.INoticesDAO;
import com.model.Notices;
import com.util.DBHelper;

/**
 * ���ݳ־ò�
 * @author Administrator
 *
 */
public class NoticesDAOImpl implements INoticesDAO {

	private final String SQL = "select id, owner , content , show_time from tbl_notices ";
	
	@Override
	public void addNotice(Notices n) throws Exception {
		String sql  = "insert into tbl_notices (owner, content , show_time) values (?,?,?)";
		DBHelper.executeUpdate(sql , n.getOwner(), n.getContent(),n.getShowTime());
	}

	@Override
	public void delNotice(int id) throws Exception {
		String sql = "delete from tbl_notices where id = " + id;
		DBHelper.executeUpdate(sql);
	}

	@Override
	public void updNotice(Notices n) throws Exception {
		String sql  = "update tbl_notices set owner = ? , content = ? , show_time = ?  where id = ?";
		DBHelper.executeUpdate(sql, n.getOwner() , n.getContent(), n.getShowTime() , n.getId());
	}

	private List<Notices> getListInfo(ResultSet rs) throws Exception{
		List<Notices> list = new ArrayList<Notices>() ;
		while(rs.next()){
			int id = rs.getInt("id");
			String owner = rs.getString("owner");
			String content = rs.getString("content");
			/*
			 * 1��java.sql.Date�����SQL���ʹ�õģ���ֻ�������ڶ�û��ʱ�䲿��,һ���ڶ�д���ݿ��ʱ����,PreparedStament��setDate
			 * ()�Ĳ�����ResultSet��getDate()�����Ķ���java.sql.Date
			 * 2��java.util.Date���ڳ���SQL�����������ʹ��,һ�����ճ������ֶ�.
			 */
			Date showTime = rs.getDate("show_time");
			Notices n = new Notices(id, owner, content, showTime);
			list.add(n);
		}
		rs.close();
		return list ; 
	}
	
	/**
	 * ��ѯ����
	 */
	@Override
	public List<Notices> queryAll() throws Exception {
		ResultSet rs = DBHelper.executeQuery(SQL);
		return getListInfo(rs);
	}
	
	/**
	 * ����������ģ����ѯ
	 */
	@Override
	public List<Notices> queryNoticesByName(String name) throws Exception {
		String sql  = this.SQL + " where content like '%"+name+"%'" ;
		return getListInfo(DBHelper.executeQuery(sql));
	}

	/**
	 * ���ݽ������ȡ��������
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Notices getNoticesInfo(ResultSet rs) throws Exception{
		//����һ�������������һ��List���� �� 
		List<Notices> list = getListInfo(rs);
		return list.size() > 0 ? list.get(0) : null ; 
	}
	
	@Override
	public Notices queryNoticeById(int id) throws Exception {
		String sql = this.SQL + " where id = " + id ; 
		return getNoticesInfo(DBHelper.executeQuery(sql));
	}

	@Override
	public Notices queryNoticeByShowTimeLimitOne() throws Exception {
		String sql = this.SQL + " order by show_time desc limit 1" ;
		return getNoticesInfo(DBHelper.executeQuery(sql));
	}

	/**
	 * ��ҳ��ѯָ��������
	 */
	@Override
	public List<Notices> queryAllByPage(int startIndex, int rows, String content) throws Exception {
		String sql  = this.SQL;
		if(content != null){
			sql += " where content like '%"+content+"%' " ;
		}
		sql += " order by show_time desc limit " + startIndex +" , "  + rows ; 
		return getListInfo(DBHelper.executeQuery(sql)); 
	}

	/**
	 * ��ȡ�ܵ�������
	 */
	@Override
	public int getTotalCount(String content) throws Exception {
		/* sql����е�count(*),��ʾ��ѯ�������м�¼���ܸ���.��˴���ʾ���ǲ�ѯtbl_notices����������м�¼���ܸ��� */
		String sql = "select count(*) as total from tbl_notices " ;
		if(content != null){
			sql += " where content like '%"+content+"%' " ;
		}
		ResultSet rs = DBHelper.executeQuery(sql);
		/* ΪʲôҪָ�������ƶ�һ��? 
		 * 		��Ϊָ����Ĭ��ָ���һ�е�,����һ��һ����˵û������,���Ҫ��ȡ��������е�����,����Ҫʹָ�������ƶ�һ��.*/
		rs.next() ;  //ָ�������ƶ�һ��
		int total = rs.getInt("total");
		rs.close();   // too many connection  ̫�������  ���ݿ����ӳ�  ��ܼ��� 
		return total;
	}
}
