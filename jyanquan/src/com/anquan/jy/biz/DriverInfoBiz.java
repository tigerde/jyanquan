package com.anquan.jy.biz;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.anquan.jy.dao.TrafficAccidentDao;
import com.anquan.jy.dao.TrafficViolationDao;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.util.Page;

public class DriverInfoBiz {
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getTrafficAccidents(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=TrafficAccidentDao.getTrafficAccidentCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficAccident> list=TrafficAccidentDao.getTrafficAccidents(id,sql);
		System.out.println(list.size());
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	/**
	 * 获取驾驶员交通违章列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getTrafficViolations(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=TrafficViolationDao.getTrafficViolationCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficViolation> list=TrafficViolationDao.getTrafficViolations(id,sql);
		System.out.println(list.size());
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	
}
