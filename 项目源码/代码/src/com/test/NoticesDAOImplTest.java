package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dao.INoticesDAO;
import com.impl.NoticesDAOImpl;
import com.model.Notices;

public class NoticesDAOImplTest {
	/*
	 * 为什么NoticesDAOImpl类中没有构造方法,但还是可以实例化接口对象呢?
	 * 这是因为每个类都默认的有一个无参的构造方法,当你不主动在类中建立有参构造方法时,可以不去建立构造方法,系统会默认给你建一个无参的,
	 * 如此处的NoticesDAOImpl类中没有建立有参的构造方法,那它就不需要再去建无参的构造方法,系统会自动给你建.
	 * 但当你在一个类中建立了有参的构造方法时,自动建无参的机制就会取消,此时你需要在该类中自己创建无参的构造方法,才可以在外部进行无参的创建对象.
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