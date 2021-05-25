package com.service;

import java.util.Date;
import java.util.List;

import com.mysql.cj.util.StringUtils;

import com.impl.Tbl_MessagesDAOImpl;
import com.model.Tbl_Messages;

public class Tbl_MessagesService {
	Tbl_MessagesDAOImpl tb = new Tbl_MessagesDAOImpl();
	private final int ROWS_NUM = 3 ;
	
	public int getTotalPage(String content, boolean flag) throws Exception{
		int count = -1;
		count = tb.getTotalCount(content);
		if(flag) {
			return (int)Math.ceil(count*1.0/this.ROWS_NUM);
		}
		return count;
	}
	public String addMessages(String name,String content, String phone, Date mtime) throws Exception{
		
		if(StringUtils.isEmptyOrWhitespaceOnly(name)||StringUtils.isEmptyOrWhitespaceOnly(content)||StringUtils.isEmptyOrWhitespaceOnly(phone)) {
			return "error!";
		}else {
			Tbl_Messages m = new Tbl_Messages(name,content,phone, mtime);
			tb.addMessage(m);
		}
		return "ok";
	}
	
	public String delMessage(int id) throws Exception{
		
		if(String.valueOf(id) == null||id < 0) {
			return "error!";
		}else if(String.valueOf(tb.querryById(id)) == null) {
			return "Error! Select id is not exist!";
		}else {
			tb.delMessage(id);
		}
		return "ok";
	}
	
	public String updMessages(int id, String name, String content, String phone, Date mtime) throws Exception{
		
		if(StringUtils.isEmptyOrWhitespaceOnly(name)||StringUtils.isEmptyOrWhitespaceOnly(content)||StringUtils.isEmptyOrWhitespaceOnly(phone)) {
			return "Error! Input content have null!";
		}else if(String.valueOf(tb.querryById(id)) == null){
			return "Error! Select id is not exist!";
		}else {
			Tbl_Messages m = tb.querryById(id);
			m.setName(name);
			m.setContent(content);
			m.setPhone(phone);
			m.setMtime(mtime);
			tb.updMessage(m);
		}
		return "ok";
	}
	
	public Tbl_Messages querryById(int id) throws Exception{
		
		Tbl_Messages m = null;
		if(String.valueOf(id) == null || id < 0) {
			return m;
		}else {
			m = tb.querryById(id);
		}
		return m;
	}
	
	public List<Tbl_Messages> querryByPage(int page, String content) throws Exception{
		
		if(page < 1){
			page = 1 ;
		}
		int totalPage = getTotalPage(content, true);
		if(page > totalPage){
			page = totalPage;
		}
		
		int startIndex = (page-1)* this.ROWS_NUM;
		List<Tbl_Messages> list = null ; 
		try {
			list = tb.querryAllByPage(startIndex, this.ROWS_NUM, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
}
