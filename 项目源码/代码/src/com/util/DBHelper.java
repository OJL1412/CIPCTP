package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {

	/**
	 * 获取数据库连接
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
	 * 增删改 通用方法
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	
	public static int executeUpdate(String sql,Object...obj)throws Exception{
		Connection conn=getConnection();
		
		//PreparedStatement对象
		PreparedStatement pre=conn.prepareStatement(sql);
		
		//传递参数1,2 0长度是可以变化的，类型int String Date
		for(int i=0;i<obj.length;i++) {
			pre.setObject(1+i, obj[i]);
		}
		
		int count=pre.executeUpdate();
		System.out.println("执行成功");
		
		pre.close();
		conn.close();
		return count;
	}
	
	
	
	/**
	 * 查询数据的通用方法
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	
	public static ResultSet executeQuery(String sql,Object...obj)throws Exception{
		Connection conn=getConnection();
		
		//PreparedStatement对象
		PreparedStatement pre=conn.prepareStatement(sql);
		
		//传递参数1,2 0长度是可以变化的，类型int String Date
		for(int i=0;i<obj.length;i++) {
			pre.setObject(1+i, obj[i]);
		}
		
		ResultSet rs=pre.executeQuery();

		return rs;
	}
	

}
