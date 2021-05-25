package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dao.INoticesDAO;
import com.impl.NoticesDAOImpl;
import com.model.Notices;

public class NoticesDAOImplTest {
	/*
	 * ΪʲôNoticesDAOImpl����û�й��췽��,�����ǿ���ʵ�����ӿڶ�����?
	 * ������Ϊÿ���඼Ĭ�ϵ���һ���޲εĹ��췽��,���㲻���������н����вι��췽��ʱ,���Բ�ȥ�������췽��,ϵͳ��Ĭ�ϸ��㽨һ���޲ε�,
	 * ��˴���NoticesDAOImpl����û�н����вεĹ��췽��,�����Ͳ���Ҫ��ȥ���޲εĹ��췽��,ϵͳ���Զ����㽨.
	 * ��������һ�����н������вεĹ��췽��ʱ,�Զ����޲εĻ��ƾͻ�ȡ��,��ʱ����Ҫ�ڸ������Լ������޲εĹ��췽��,�ſ������ⲿ�����޲εĴ�������.
	 */

	private INoticesDAO nao = new NoticesDAOImpl();
	
	@Test
	public void testQueryAllByPage() {
		int rows = 3 ; 
		int page = 2 ; 
		int startIndex = rows * (page - 1);
		try {
			List<Notices> list = nao.queryAllByPage(startIndex ,rows, null) ;
			for(Notices n : list){
				System.out.println(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}