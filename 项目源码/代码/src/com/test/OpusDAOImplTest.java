package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.dao.IOpusDAO;
import com.impl.OpusDAOImpl;
import com.model.Opus;
import com.model.OpusInfo;

class OpusDAOImplTest {

	private IOpusDAO tao;
	
	@Before
	public void init() {
		tao = new OpusDAOImpl();
	}
	
	@Test
	void testAddOpus() {
		Opus o = new Opus();
		o.setAuthor("大千");
		o.setCk(0);
		o.setImg("23");
		o.setIntroduce("好看");
		o.setName("山峰");
		o.setSid(5);
		o.setTid(1);
		o.setUtime(new Date());
		try {
			tao.addOpus(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDelOpus() {
		try {
			tao.delOpus(31);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdOpus() {
		Opus o = new Opus();
		o.setId(31);
		o.setAuthor("大千");
		o.setCk(0);
		o.setImg("23");
		o.setIntroduce("好看");
		o.setName("山峰");
		o.setSid(5);
		o.setTid(1);
		o.setUtime(new Date());
		try {
			tao.updOpus(o);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testQueryOpusById() {
		Opus o = null;
		try {
			o = tao.queryOpusById(31);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(o);
	}

	@Test
	void testQueryOpusAllBypage() {
		List<OpusInfo> opusList = new ArrayList<OpusInfo>();
		try {
			opusList = tao.queryOpusAllBypage(0, 3, "");
		}  catch (Exception e) {
			e.printStackTrace();
		}
		for (OpusInfo o : opusList) {
			System.out.println(o);
		}
	}

	@Test
	void testGetTotalCount() {
		try {
			int totalCount = tao.getTotalCount("");
			System.out.println(totalCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testQueryAll() {
		List<OpusInfo> opusList = new ArrayList<OpusInfo>();
		try {
			opusList = tao.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (OpusInfo o : opusList) {
			System.out.println(o);
		}
	}

	@Test
	void testQueryAllByName() {
		List<OpusInfo> opusList = new ArrayList<OpusInfo>();
		try {
			opusList = tao.queryAllByName("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (OpusInfo o : opusList) {
			System.out.println(o);
		}
	}

}
