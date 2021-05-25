package com.dao;

import java.util.List;

import com.model.Opus;
import com.model.OpusInfo;

public interface IOpusDAO {

	void addOpus(Opus o) throws Exception ;
	
	void delOpus(int id) throws Exception ;
	
	void updOpus(Opus o) throws Exception ;
	
	Opus queryOpusById(int id) throws Exception ;
	
	List<OpusInfo> queryAll() throws Exception ;
	
	List<OpusInfo> queryAllByName(String name) throws Exception ;
	
	/**
	  * �����������з�ҳ��ѯ
	 * @param startIndex
	 * @param rows
	 * @param content
	 * @return
	 * @throws Exception
	 */
	List<OpusInfo> queryOpusAllBypage(int startIndex, int rows, String content) throws Exception ;
	
	/**
	  * ����������ѯ��������
	 * @param content
	 * @return
	 * @throws Exception
	 */
	int getTotalCount(String content) throws Exception ;
	
}
