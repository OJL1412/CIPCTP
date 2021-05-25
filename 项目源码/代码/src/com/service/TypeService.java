package com.service;

import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.dao.ITypesDAO;
import com.impl.TypesDAOImpl;
import com.model.Types;

public class TypeService {
	private ITypesDAO tao = new TypesDAOImpl();
	
	public String addType(String name , int parentId){
		if(StringUtils.isNullOrEmpty(name) || parentId < 0){
			return "参数有误" ;
		}
		Types t  = new Types(0, name, parentId);
		try {
			tao.addType(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	public String delTypeById(int id){
		if(id < 0){
			return "参数有误";
		}
		Types t = null ; 
		try {
			t = tao.queryTypeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(t == null){
			return "id不存在";
		}
		try {
			tao.delType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	public String updTypes(int id, String name , int parentId){
		if(StringUtils.isNullOrEmpty(name) || parentId < 0 || id < 0){
			return "参数有误" ;
		}
		Types t = null ; 
		try {
			t = tao.queryTypeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(t == null){
			return "id不存在";
		}
		t.setName(name);
		t.setParentId(parentId);
		try {
			tao.updType(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	public Types qeuryTpById(int id){
		Types t = null ; 
		try {
			t = tao.queryTypeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t; 
	}
	
	public List<Types> queryAll(int pid){
		List<Types> list = null; 
		try {
			list = tao.queryAll(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
}	
