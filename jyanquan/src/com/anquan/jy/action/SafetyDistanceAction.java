package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.dao.SafetyDistanceDao;
import com.anquan.jy.entity.SafetyDistance;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SafetyDistanceAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;// 页码
	private int pageSize;// 页值
	private String sidx;// 排序字段
	private String sord;// 排序方式 asc /desc
	private boolean _search=false;// 是否搜索 true false
	private String oper; // 增删改判断标记
	private String id;
	private JSONObject json;
	
	private String idcard;// '身份证',
	
	private String bus_number;// '车号',
	private int year;// '年份',
	private int month;// '月份',
	private double mileage_month;// '本月安全里程',
	private double mileage_year;// '年度安全里程',
	private double mileage;// '累计安全里程',
	
	
	
	public String getSafetyDistance(){
		json=DriverInfoBiz.getSafetyDistances(pageNo, pageSize, sidx, sord, id);
		return SUCCESS;
	}
	/**
	 * 编辑驾驶员违章违纪信息
	 */
	public void editSafetyDistance(){
		if (oper.equals("del")){
			//删除
			SafetyDistanceDao.delSafetyDistance(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			SafetyDistance be=new SafetyDistance();
			be.setId(id);
			be.setIdcard(idcard);
			be.setBus_number(bus_number);
			be.setMonth(month);
			be.setYear(year);
			be.setMileage_month(mileage_month);
			be.setMileage_year(mileage_year);
			be.setMileage(mileage);
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			SafetyDistanceDao.updateSafetyDistance(be);
		}else if(oper.equals("add")){
			SafetyDistance be=new SafetyDistance();
			be.setIdcard(idcard);
			be.setBus_number(bus_number);
			be.setMonth(month);
			be.setYear(year);
			be.setMileage_month(mileage_month);
			be.setMileage_year(mileage_year);
			be.setMileage(mileage);
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			be.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			be.setCreate_user_id("1");
			SafetyDistanceDao.insertSafetyDistance(be);
		}
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public boolean is_search() {
		return _search;
	}
	public void set_search(boolean search) {
		_search = search;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBus_number() {
		return bus_number;
	}
	public void setBus_number(String busNumber) {
		bus_number = busNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getMileage_month() {
		return mileage_month;
	}
	public void setMileage_month(double mileageMonth) {
		mileage_month = mileageMonth;
	}
	public double getMileage_year() {
		return mileage_year;
	}
	public void setMileage_year(double mileageYear) {
		mileage_year = mileageYear;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	 
}
