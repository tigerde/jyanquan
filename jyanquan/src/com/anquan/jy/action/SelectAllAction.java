package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverBiz;
import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.biz.SelectAllBiz;
import com.anquan.jy.dao.TrafficAccidentDao;
import com.anquan.jy.dao.TrafficViolationDao;
import com.anquan.jy.entity.Driver;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAllAction extends ActionSupport {
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
	private String starttime;
	private String endtime;
	private String type;
	private String idcard;// '身份证',
	private String company;// '分公司',
	private String line_number;// '线路',
	private String bus_number;// '事故车号',
	private String name;// '驾驶员',
	private String accident_date;// '事故时间',
	private String accident_location;// '事故地点',
	private String accident_summary;// '事故经过',
	private String accident_liability;// '责任',
	private String result;// '处理情况',
	private String reporter;// T '汇报人',
	
	
	
	public String getDriverAccident(){
		json=SelectAllBiz.getAccidents(pageNo, pageSize, sidx, sord, id,starttime,endtime,type);
		return SUCCESS;
	}
	/**
	 * 编辑驾驶员交通事故信息
	 */
	public void editTrafficAccident(){
		if (oper.equals("del")){
			//删除
			TrafficAccidentDao.delTrafficAccident(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			TrafficAccident ta=new TrafficAccident();
			ta.setId(id);
			ta.setIdcard(idcard);
			ta.setCompany(company);
			ta.setLine_number(line_number);
			ta.setBus_number(bus_number);
			//ta.setName("");
			ta.setAccident_date(accident_date);
			ta.setAccident_location(accident_location);
			ta.setAccident_summary(accident_summary);
			ta.setAccident_liability(accident_liability);
			ta.setResult(result);
			ta.setReporter(reporter);
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			ta.setModifi_user_id("1");
			TrafficAccidentDao.updateTrafficAccident(ta);
		}else if(oper.equals("add")){
			TrafficAccident ta=new TrafficAccident();
			ta.setIdcard(idcard);
			ta.setCompany(company);
			ta.setLine_number(line_number);
			ta.setBus_number(bus_number);
			//ta.setName("");
			ta.setAccident_date(accident_date);
			ta.setAccident_location(accident_location);
			ta.setAccident_summary(accident_summary);
			ta.setAccident_liability(accident_liability);
			ta.setResult(result);
			ta.setReporter(reporter);
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			ta.setModifi_user_id("1");
			ta.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			ta.setCreate_user_id("1");
			TrafficAccidentDao.insertTrafficAccident(ta);
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
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public JSONObject getJson() {
		return json;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLine_number() {
		return line_number;
	}
	public void setLine_number(String lineNumber) {
		line_number = lineNumber;
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
	public String getAccident_date() {
		return accident_date;
	}
	public void setAccident_date(String accidentDate) {
		accident_date = accidentDate;
	}
	public String getAccident_location() {
		return accident_location;
	}
	public void setAccident_location(String accidentLocation) {
		accident_location = accidentLocation;
	}
	public String getAccident_summary() {
		return accident_summary;
	}
	public void setAccident_summary(String accidentSummary) {
		accident_summary = accidentSummary;
	}
	public String getAccident_liability() {
		return accident_liability;
	}
	public void setAccident_liability(String accidentLiability) {
		accident_liability = accidentLiability;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	
	
}
