package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverBiz;
import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.dao.DriverInfoDao;
import com.anquan.jy.entity.Driver;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class TrafficViolationAction extends ActionSupport {
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
	private String bus_number;// '车牌号',
	private String name;// '驾驶员',
	private String company;// '所属公司',
	private String violation_date;// '违章时间',
	private String violation_location;// '违章地点',
	private String violation_reason;// '违章原因',
	private int points;// '扣分',
	private double fine;// '罚款',
	private String assessment_date;// '绩效考核时间',
	
	
	
	public String getDriverTrafficViolation(){
		json=DriverInfoBiz.getTrafficViolations(pageNo, pageSize, sidx, sord, id);
		return SUCCESS;
	}
	/**
	 * 编辑驾驶员交通事故信息
	 */
	public void editTrafficViolation(){
		if (oper.equals("del")){
			//删除
			DriverInfoDao.delTrafficViolation(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			TrafficViolation ta=new TrafficViolation();
			ta.setId(id);
			ta.setIdcard(idcard);
			
			ta.setCompany(company);
			ta.setBus_number(bus_number);
			//ta.setName("");
			ta.setViolation_date(violation_date);
			ta.setViolation_location(violation_location);
			ta.setViolation_reason(violation_reason);
			ta.setPoints(points);
			ta.setFine(fine);
			ta.setAssessment_date(assessment_date);
			
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			ta.setModifi_user_id("1");
			 DriverInfoDao.updateTrafficViolation(ta);
		}else if(oper.equals("add")){
			TrafficViolation ta=new TrafficViolation();
			ta.setIdcard(idcard);
			ta.setCompany(company);
			ta.setBus_number(bus_number);
			//ta.setName("");
			ta.setViolation_date(violation_date);
			ta.setViolation_location(violation_location);
			ta.setViolation_reason(violation_reason);
			ta.setPoints(points);
			ta.setFine(fine);
			ta.setAssessment_date(assessment_date);
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			ta.setModifi_user_id("1");
			ta.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			ta.setCreate_user_id("1");
			DriverInfoDao.insertTrafficViolation(ta);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getViolation_date() {
		return violation_date;
	}
	public void setViolation_date(String violationDate) {
		violation_date = violationDate;
	}
	public String getViolation_location() {
		return violation_location;
	}
	public void setViolation_location(String violationLocation) {
		violation_location = violationLocation;
	}
	public String getViolation_reason() {
		return violation_reason;
	}
	public void setViolation_reason(String violationReason) {
		violation_reason = violationReason;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getAssessment_date() {
		return assessment_date;
	}
	public void setAssessment_date(String assessmentDate) {
		assessment_date = assessmentDate;
	}
	
	
	 
	
}
