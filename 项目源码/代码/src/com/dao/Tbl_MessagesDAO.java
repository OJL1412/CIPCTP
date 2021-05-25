package com.dao;

import java.util.List;

import com.model.Tbl_Messages;

public interface Tbl_MessagesDAO {
	void addMessage(Tbl_Messages m) throws Exception;
	
	void delMessage(int id) throws Exception;
	
	void updMessage(Tbl_Messages m) throws Exception;
	
	Tbl_Messages querryById(int id) throws Exception;
	
	List<Tbl_Messages> querryAllByPage(int StartIndex, int rows, String content) throws Exception;
	
	int getTotalCount(String content);
	
}
