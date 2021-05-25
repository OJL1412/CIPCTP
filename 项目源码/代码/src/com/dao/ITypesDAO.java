package com.dao;

import java.util.List;

import com.model.Types;

public interface ITypesDAO {

	void addType(Types n) throws Exception ; 
	
	void delType(int id) throws Exception ; 
	
	void updType(Types n) throws Exception ; 
	
	Types queryTypeById(int id) throws Exception ; 
	
	List<Types> queryAll(int pid) throws Exception ; 
}
