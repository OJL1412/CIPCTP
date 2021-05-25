package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

	/**
	 * ��ȡ���ݿ�����
	 * @return conn
	 * @throw Exception
	 */
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql:localhost:3306/web?serverTimezone=CTT&characterEncoding=utf-8";
		Connection conn=DriverManager.getConnection(url,"root","root");
		
		return conn;
		
	}
	
	
	
	/**
	 * ��ɾ�� ͨ�÷���
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	
	public static int executeUpdate(String sql,Object...obj)throws Exception{
		Connection conn=getConnection();
		
		//PreparedStatement����
		PreparedStatement pre=conn.prepareStatement(sql);
		
		//���ݲ���1,2 0�����ǿ��Ա仯�ģ�����int String Date
		for(int i=0;i<obj.length;i++) {
			pre.setObject(1+i, obj[i]);
		}
		
		int count=pre.executeUpdate();
		System.out.println("ִ�гɹ�");
		
		pre.close();
		conn.close();
		return count;
	}
	
	
	
	/**
	 * ��ѯ���ݵ�ͨ�÷���
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	
	public static ResultSet executeQuery(String sql,Object...obj)throws Exception{
		Connection conn=getConnection();
		
		//PreparedStatement����
		PreparedStatement pre=conn.prepareStatement(sql);
		
		//���ݲ���1,2 0�����ǿ��Ա仯�ģ�����int String Date
		for(int i=0;i<obj.length;i++) {
			pre.setObject(1+i, obj[i]);
		}
		
		ResultSet rs=pre.executeQuery();

		return rs;
	}
	

}
