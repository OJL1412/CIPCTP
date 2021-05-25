package com.service;

import java.util.Date;
import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.dao.IUserInfoDao;
import com.impl.IUserDaoImpl;
import com.model.UserInfo;
import com.util.MD5Util;

public class UserService {
	/**
	 * 业务逻辑层，调用数据持久层的方法   ，创建数据持久层的对象
	 * @author Administrator
	 * 1.接收参数
	 * 2.校验参数
	 * 3.业务逻辑
	 * 4.返回
	 */
	private IUserInfoDao uao = new IUserDaoImpl(); 
		
	/**
	 * 添加用户
	 * @param username
	 * @param pwd
	 * @param phone
	 * @param role_id
	 * @return
	 */
	public String addUserInfo(String name , String pwd , String phone , int role_id){
			if(StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(pwd) || StringUtils.isNullOrEmpty(phone) 
					|| role_id > 2 || role_id < 1)
			{
				return "参数有误" ;
			}
			
			//用户名不能重复
			UserInfo userinfo = null ; 
			
			try {
				userinfo = uao.queryUserInfoByName(name); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(userinfo != null){
				//用户名已经存在   重复了
				return "用户名重复";
			}
			
			userinfo = new UserInfo(); 
			userinfo.setPhone(phone);
			userinfo.setName(name);
			userinfo.setRole_id(role_id);
			//密码  123456
			try {
				userinfo.setPwd(MD5Util.md5(pwd));
				uao.addUserInfo(userinfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "ok";
		}
		
		public String delUserInfo(int id){
			if(id < 0)
				return "参数错误";
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				//id不存在
				return "id不存在";
			}
			try {
				uao.delUserInfo(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "ok";
		}

		
		public String updUserInfo(int id , String pwd , String phone , int role_id){
			if (id < 0 || role_id < 1 || role_id > 2){
				return "参数错误" ;
			}
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				return "id不存在";
			}
			//更新
			ui.setPwd(pwd);
			ui.setPhone(phone);
			ui.setRole_id(role_id);
			ui.setUpdateTime(new Date());
			
			try {
				uao.updUserInfo(ui);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "ok" ; 
		}
		
		
		/**
		 * 根据条件获取总页数
		 * @param name
		 * @return
		 */
		public int getTotalPage(String name, boolean flag){
			int totalCounts = -1 ;
			try {
				totalCounts = uao.getTotalCounts(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(flag){
				//返回总页数
				return (int)Math.ceil(totalCounts*1.0/IUserInfoDao.ROWS_NUM);
			}
			//返回总条数
			return totalCounts ; 
		}
		
		/**
		 * 分页查询用户数据
		 * @param page
		 * @param name
		 * @return
		 */
		public List<UserInfo> queryUserInfosByPage(int page, String name){
			int totalPage = getTotalPage(name, true);
			if(page > totalPage){
				page = totalPage ;
			}
			if(page < 1){
				page = 1 ; 
			}
			
			int startIndex = (page - 1) * IUserInfoDao.ROWS_NUM ;
			List<UserInfo> list = null ; 
			try {
				list = uao.queryUserInfoByPage(startIndex, name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list ; 
		}
		
		/**
		 * 根据id来查询用户信息
		 * @param id
		 * @return
		 */
		public UserInfo queryUserInfoById(int id){
			if (id < 0){
				return null ;
			}
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ui ; 
		}
		
		/**
		 * 校验用户名和密码是否正确
		 * @param name
		 * @return
		 */
		public String valiUserMsg(String name ,String pwd){
			if(StringUtils.isNullOrEmpty(name)){
				return "用户名为空" ;
			}
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoByName(name);
				pwd = MD5Util.md5(pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				return "用户名不存在" ;
			}
			if(ui.getPwd().equals(pwd)){
				return "ok" ;
			}
			return "密码错误" ;
		}

}
