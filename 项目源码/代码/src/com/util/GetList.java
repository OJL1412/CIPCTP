package com.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Tbl_Messages;
import com.model.Types;

public class GetList {
	public static List<Types> getList(ResultSet us) throws Exception{
		List<Types> list = new ArrayList<Types>();
		while(us.next()) {
			String name = us.getNString("name");
			int pid = us.getInt("pid");
			
			Types ty = new Types();
			list.add(ty);
		}
		us.close();
		return list;
		
	}
	public static List<Tbl_Messages> getListMessages(ResultSet us) throws Exception{
		List<Tbl_Messages> list = new ArrayList<Tbl_Messages>();
		while(us.next()) {
			String name = us.getNString("name");
			int pid = us.getInt("pid");
			Tbl_Messages ty = new Tbl_Messages();
			list.add(ty);
		}
		us.close();
		return list;
		
	}
}
