package com.dao;

import java.util.List;

import com.model.Notices;

public interface INoticesDAO {
	
	void addNotice(Notices n) throws Exception ; 
	
	void delNotice(int id) throws Exception ; 
	
	void updNotice(Notices n) throws Exception ; 
	
	List<Notices> queryAll() throws Exception ; 
	
	Notices queryNoticeById(int id) throws Exception ; 
	
	Notices queryNoticeByShowTimeLimitOne() throws Exception ; 
	
	List<Notices> queryNoticesByName(String name) throws Exception ; 
	
	/**
	 * �����������з�ҳ��ѯ
	 * @param startIndex
	 * @param rows
	 * @param content
	 * @return
	 * @throws Exception
	 */
	List<Notices> queryAllByPage(int startIndex, int rows , String content) throws Exception ; 
	
	/**
	 * ����������ѯ��������
	 * @param content
	 * @return
	 * @throws Exception
	 */
	int getTotalCount(String content) throws Exception ;
	
}
