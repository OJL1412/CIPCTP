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
	 * ҵ���߼��㣬�������ݳ־ò�ķ���   ���������ݳ־ò�Ķ���
	 * @author Administrator
	 * 1.���ղ���
	 * 2.У�����
	 * 3.ҵ���߼�
	 * 4.����
	 */
	private IUserInfoDao uao = new IUserDaoImpl(); 
		
	/**
	 * ����û�
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
				return "��������" ;
			}
			
			//�û��������ظ�
			UserInfo userinfo = null ; 
			
			try {
				userinfo = uao.queryUserInfoByName(name); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(userinfo != null){
				//�û����Ѿ�����   �ظ���
				return "�û����ظ�";
			}
			
			userinfo = new UserInfo(); 
			userinfo.setPhone(phone);
			userinfo.setName(name);
			userinfo.setRole_id(role_id);
			//����  123456
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
				return "��������";
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				//id������
				return "id������";
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
				return "��������" ;
			}
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				return "id������";
			}
			//����
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
		 * ����������ȡ��ҳ��
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
				//������ҳ��
				return (int)Math.ceil(totalCounts*1.0/IUserInfoDao.ROWS_NUM);
			}
			//����������
			return totalCounts ; 
		}
		
		/**
		 * ��ҳ��ѯ�û�����
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
		 * ����id����ѯ�û���Ϣ
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
		 * У���û����������Ƿ���ȷ
		 * @param name
		 * @return
		 */
		public String valiUserMsg(String name ,String pwd){
			if(StringUtils.isNullOrEmpty(name)){
				return "�û���Ϊ��" ;
			}
			UserInfo ui = null ; 
			try {
				ui = uao.queryUserInfoByName(name);
				pwd = MD5Util.md5(pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(ui == null){
				return "�û���������" ;
			}
			if(ui.getPwd().equals(pwd)){
				return "ok" ;
			}
			return "�������" ;
		}

}
