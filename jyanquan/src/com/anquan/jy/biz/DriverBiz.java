package com.anquan.jy.biz;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.anquan.jy.dao.AnquanDao;
import com.anquan.jy.entity.Driver;
import com.anquan.jy.util.Page;

public class DriverBiz {
	
	/**
	 * 根据条件获取驾驶员概要信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param sqlsearch
	 * @return
	 */
	public static JSONObject getDrivers(int pageNo,int pageSize,String sidx,String sord,String sqlsearch){
		List<Driver> list=null;
		int i=0;
		Page page=new Page();
		i=AnquanDao.getDriversCount(sqlsearch);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		sqlsearch=sqlsearch+" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		list=AnquanDao.getDrivers(sqlsearch);
		JSONArray jsonArray=JSONArray.fromObject(list);
		
		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	
	/**
	 * 获取驾驶员信息
	 * @param id
	 * @return
	 */
	public static JSONObject getDriver(String id) {
		JSONObject json=new JSONObject();
		List<Driver> list=new ArrayList<Driver>();
		Driver driver=AnquanDao.getDriver(id);
		if(driver!=null){
			list.add(driver);
		}
		JSONArray jsonArray=JSONArray.fromObject(list);
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", 0);
		json.accumulate("pageNo", 0);
		json.accumulate("dataCount", 0);
		return json;
	}
	
	/**
	 * 删除驾驶员信息
	 * @param id
	 * @return
	 */
	public static boolean delDriver(String id){
		return AnquanDao.delDriver(id)>0;
	}
	
	/**
	 * 修改驾驶员信息
	 * @param driver
	 * @return
	 */
	public static boolean updateDriver(Driver driver){
		return AnquanDao.updateDriver(driver)>0;
	}
	/**
	 * 创建驾驶员信息
	 * @param driver
	 * @return
	 */
	public static boolean insertDriver(Driver driver){
		return AnquanDao.insertDriver(driver)>0;
	}
	
	
}
