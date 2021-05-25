package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dao.Tbl_MessagesDAO;
import com.impl.Tbl_MessagesDAOImpl;
import com.model.Tbl_Messages;

class Tbl_MessagesDAOImplTest {
	private Tbl_MessagesDAO m = new Tbl_MessagesDAOImpl();
	@Test
	void testAddMessage() {
		Tbl_Messages ms = new Tbl_Messages("xiao","nihao","13302948",new Date());
		try {
			m.addMessage(ms);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testDelMessage() {
		try {
			m.delMessage(1);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testUpdMessage() {
		Tbl_Messages ms = new Tbl_Messages("xiao", "niao","1214",new Date());
		try {
			m.updMessage(ms);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testQuerryById() {
		try {
			m.querryById(1);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testQuerryAllByPage() {
		try {
			m.querryAllByPage(1, 3, "qwdq");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Test
	void testGetTotalCount() {
		m.getTotalCount("asdniu");
	}

}
