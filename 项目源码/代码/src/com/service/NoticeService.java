package com.service;

import java.util.Date;
import java.util.List;

import com.mysql.cj.protocol.x.Notice;
import com.mysql.cj.util.StringUtils;
import com.dao.INoticesDAO;
import com.impl.NoticesDAOImpl;
import com.model.Notices;

/**
 * 业务逻辑层
 * 需要调用数据持久层的方法 
 * @author Administrator
 *
 */
public class NoticeService {
	
	private INoticesDAO nao = new NoticesDAOImpl();
	private final int ROWS_NUM = 3 ; 
	/**
	 * 1.获取参数
	 * 2.校验参数
	 * 3.业务逻辑
	 * 4.返回值
	 * @param owner
	 * @param content
	 * @return
	 */
	public String addNotices(String owner , String content){
		String msg = null ; 
		/* 如何判断int类型的数据是否为空? 
		 * 		eg1:String.valueOf(id) == null,此为判断int类型的数据id是否为空.
		 * 		eg2:StringUtils.isEmptyOrWhitespaceOnly(name),此为判断String类型的数据name是否为空.
		 * */
		
		if(StringUtils.isEmptyOrWhitespaceOnly(owner) || StringUtils.isEmptyOrWhitespaceOnly(content)){
			msg = "error";
		}else{
			Notices n = new Notices() ; 
			n.setOwner(owner);
			n.setContent(content);
			n.setShowTime(new Date());
			try {
				nao.addNotice(n);
				msg = "ok" ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	public String delNotices(int id){
		String msg = "";
		if(id < 0){
			msg = "error" ;
		}else{
			try {
				//查询 id 是否存在
				Notices n = nao.queryNoticeById(id);
				if(n == null){
					//id不存在
					msg = "id 不存在" ;
				}else{
					//删除
					nao.delNotice(id);
					msg = "ok" ;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	public String mergeNotices(int id , String owner , String content){
		String msg = null ; 
		if(StringUtils.isEmptyOrWhitespaceOnly(owner) || StringUtils.isEmptyOrWhitespaceOnly(content)){
			msg = "error";
		}else{
			Notices n = new Notices(id , owner , content , new Date()) ;
			try {
				nao.updNotice(n);
				msg = "ok" ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return msg ; 
	}
	
	/**
	 * 1. 查询所有的 。 
	 * 2. 根据名称来模糊查询 。 
	 * @return
	 */
	public List<Notices> queryAll(String name){
		List<Notices> list = null ; 
		try {
			if(name == null){
				list = nao.queryAll();
			}else{
				list = nao.queryNoticesByName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
	
	/**
	 * 1. 根据id查询单个的。 
	 * 2. 默认查询发布时间最新的公告
	 * @return
	 */
	public Notices queryNotice(int id){
		Notices n = null ; 
		try {
			if(id == 0){
				//默认查询发布时间最新的公告
				n = nao.queryNoticeByShowTimeLimitOne();
			}else{
				n = nao.queryNoticeById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n ; 
	}
	
	/**
	 * 获取总页数
	 * @param content
	 * @return
	 */
	public int getTotalPage(String content){
		int totalCount = -1 ; 
		try {
			totalCount = nao.getTotalCount(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int)Math.ceil(totalCount * 1.0 / ROWS_NUM); 
	}
	
	
	/**
	 * 分页查询数据
	 * @param page
	 * @param content
	 * @return
	 */
	public List<Notices> queryAllByPage(int page , String content){
		int totalPage = getTotalPage(content);
		if(page < 0 || page > totalPage){
			System.err.println("参数有误");
			return null ; 
		}

		int startIndex = (page -1) * ROWS_NUM ;
		List<Notices> list = null ; 
		try {
			list = nao.queryAllByPage(startIndex, ROWS_NUM, content); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list ; 
	}
	
	
}
