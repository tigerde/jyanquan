package com.anquan.jy.biz;


import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.anquan.jy.dao.BehaviorDao;
import com.anquan.jy.dao.DisciplineDao;
import com.anquan.jy.dao.MechAccidentDao;
import com.anquan.jy.dao.SafetyDistanceDao;
import com.anquan.jy.dao.SelectAllDao;
import com.anquan.jy.dao.TrafficAccidentDao;
import com.anquan.jy.dao.TrafficViolationDao;
import com.anquan.jy.entity.Behavior;
import com.anquan.jy.entity.Discipline;
import com.anquan.jy.entity.SafetyDistance;
import com.anquan.jy.entity.SelectAccident;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.util.Page;

public class SelectAllBiz {
	
	/**
	 * 获取驾驶员交通事故信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param sidx
	 * @param sord
	 * @param id
	 * @return
	 */
	public static JSONObject getAccidents(int pageNo, int pageSize, String sidx, String sord,String id,String starttime,String endtime,String type){
		int i=0;
		Page page=new Page();
		i=SelectAllDao.getAccidentCount(starttime,endtime,type);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//traffic_accident
		String sql="select '交通事故' type, a.id,a.idcard,b.name,b.company,a.line_number,a.bus_number,a.accident_date,a.accident_location,a.accident_summary,a.accident_liability,a.result,a.result,a.reporter from traffic_accident a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and a.accident_date between '"+starttime+"' and '"+endtime+"'"
		+" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<SelectAccident> list=SelectAllDao.getSelectAccidents(sql);
		 
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
	public static JSONObject getTrafficAccidents(int pageNo, int pageSize, String sidx, String sord,String id,String starttime,String endtime,String type){
		int i=0;
		Page page=new Page();
		i=TrafficAccidentDao.getTrafficAccidentCount(id);
		page.setDataCount(i);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//traffic_accident
		String sql="";
		sql="select '交通事故' type, a.id,a.idcard,b.name,b.company,a.line_number,a.bus_number,a.accident_date,a.accident_location,a.accident_summary,a.accident_liability,a.result,a.result,a.reporter from traffic_accident a left join drivers b on a.idcard=b.id where  a.deleted=0 and b.deleted=0 and a.accident_date between '"+starttime+"' and '"+endtime+"'";
		if(type.equals("traffic_accident")){
			sql="";
		}else if(type.equals("traffic_violation")){
			sql="";
		}else if(type.equals("mechanical_accident")){
			sql="";
		}else if(type.equals("behavior")){
			sql="";
		}else if(type.equals("discipline")){
			sql="";
		}else if(type.equals("all")){
			sql="";
		}
		
		sql=" order by "+sidx+" "+sord+" limit "+ (page.getPageNo() - 1) * page.getPageSize() + "," + page.getPageSize();
		List<SelectAccident> list=SelectAllDao.getSelectAccidents(sql);
		
		JSONArray jsonArray=JSONArray.fromObject(list);		
		JSONObject json=new JSONObject();
		json.accumulate("account", jsonArray);
		json.accumulate("pageCount", page.getPageCount());
		json.accumulate("pageNo", page.getPageNo());
		json.accumulate("dataCount", page.getDataCount());
		return json;
	}
	
}
