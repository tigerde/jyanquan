package com.anquan.jy.biz;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.anquan.jy.dao.AnquanDao;
import com.anquan.jy.dao.SafetyDistanceDao;
import com.anquan.jy.dao.UserDao;
import com.anquan.jy.entity.SafetyDistance;
import com.anquan.jy.entity.User;
import com.anquan.jy.util.Page;

public class UserBiz {
	public static User checklogin(String username,String password){
		User user=null;
			user=AnquanDao.checkLogin(username, password);
		return user;
	}
	
	
	
	/**
	 * 获取驾驶员安全里程列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getUsers(int pageNo, int pageSize, String sidx, String sord){
		int i=0;
		Page page=new Page();
		i=UserDao.getUserCount();
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		//String sql=" order by year desc , month  desc  limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<User> list=UserDao.getUsers(sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
}
