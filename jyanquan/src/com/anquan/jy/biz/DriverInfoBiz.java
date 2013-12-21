package com.anquan.jy.biz;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.anquan.jy.dao.BehaviorDao;
import com.anquan.jy.dao.DisciplineDao;
import com.anquan.jy.dao.MechAccidentDao;
import com.anquan.jy.dao.SafetyDistanceDao;
import com.anquan.jy.dao.TrafficAccidentDao;
import com.anquan.jy.dao.TrafficViolationDao;
import com.anquan.jy.entity.Behavior;
import com.anquan.jy.entity.Discipline;
import com.anquan.jy.entity.SafetyDistance;
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
	public static JSONObject getTrafficAccidents(int pageNo, int pageSize, String sidx, String sord,String starttime,String endtime){
		int i=0;
		Page page=new Page();
		i=TrafficAccidentDao.getTrafficAccidentCount(starttime,endtime);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficAccident> list=TrafficAccidentDao.getTrafficAccidents(starttime,endtime,sql);
		 
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
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
	 * 获取驾驶员交通事故信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getMechAccidents(int pageNo, int pageSize, String sidx, String sord,String starttime,String endtime){
		int i=0;
		Page page=new Page();
		i=MechAccidentDao.getTrafficAccidentCount(starttime,endtime);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficAccident> list=MechAccidentDao.getTrafficAccidents(starttime,endtime,sql);
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
	 * 获取驾驶员交通事故信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getMechAccidents(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=MechAccidentDao.getTrafficAccidentCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficAccident> list=MechAccidentDao.getTrafficAccidents(id,sql);
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
	public static JSONObject getTrafficViolations(int pageNo, int pageSize, String sidx, String sord,String starttime,String endtime){
		int i=0;
		Page page=new Page();
		i=TrafficViolationDao.getTrafficViolationCount(starttime,endtime);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<TrafficViolation> list=TrafficViolationDao.getTrafficViolations(starttime,endtime,sql);
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
	/**
	 * 获取驾驶员行为列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getBehaviors(int pageNo, int pageSize, String sidx, String sord,String starttime,String endtime){
		int i=0;
		Page page=new Page();
		i=BehaviorDao.getBehaviorCount(starttime,endtime);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<Behavior> list=BehaviorDao.getBehaviors(starttime,endtime, sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	/**
	 * 获取驾驶员行为列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getBehaviors(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=BehaviorDao.getBehaviorCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<Behavior> list=BehaviorDao.getBehaviors(id, sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	
	/**
	 * 获取驾驶员行为列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getDisciplines(int pageNo, int pageSize, String sidx, String sord,String starttime,String endtime){
		int i=0;
		Page page=new Page();
		i=DisciplineDao.getDisciplineCount(starttime,endtime);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<Discipline> list=DisciplineDao.getDisciplines(starttime,endtime, sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	/**
	 * 获取驾驶员行为列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getDisciplines(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=DisciplineDao.getDisciplineCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<Discipline> list=DisciplineDao.getDisciplines(id, sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
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
	public static JSONObject getSafetyDistances(int pageNo, int pageSize, String sidx, String sord,String id){
		int i=0;
		Page page=new Page();
		i=SafetyDistanceDao.getSafetyDistanceCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//String sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		String sql=" order by year desc , month  desc  limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<SafetyDistance> list=SafetyDistanceDao.getSafetyDistances(id, sql);
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
}
