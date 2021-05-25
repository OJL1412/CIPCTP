package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dao.ITypesDAO;
import com.impl.TypesDAOImpl;
import com.model.Types;

class TypesDAOImplTest {

	ITypesDAO td = new TypesDAOImpl();
	@Test
	void testAddType() {
		Types t = new Types(1,"shi",2);
		try {
			td.addType(t);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("nihao");
	}

	@Test
	void testDelType() {
		try {
			td.delType(1);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testUpdType() {
		Types t = new Types(2,"nishia",3);
		try {
			td.updType(t);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testQueryTypeById() {
		try {
			td.queryTypeById(2);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testQueryAll() {
		try {
			td.queryAll(2);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
