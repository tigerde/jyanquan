package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.dao.BadBehaviorDao;
import com.anquan.jy.dao.BehaviorDao;
import com.anquan.jy.entity.Behavior;
import com.anquan.jy.entity.TrafficViolation;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BadBehaviorAction extends ActionSupport {
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
	private String name;// '驾驶员',
	private String incident_date;// '时间',
	private String incident_location;// '地点',
	private String description;// '经过',
	private String result;// '结果',
	private String starttime;
	private String endtime;
	
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getBehavior(){
		if(id!=null&&!id.equals("")){
			json=DriverInfoBiz.getBadBehaviors(pageNo, pageSize, sidx, sord, id);
		}else{
			json=DriverInfoBiz.getBadBehaviors(pageNo, pageSize, sidx, sord, starttime,endtime);
		}
		return SUCCESS;
	}
	/**
	 * 编辑驾驶员交通事故信息
	 */
	public void editBehavior(){
		if (oper.equals("del")){
			//删除
			BadBehaviorDao.delBehavior(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			Behavior be=new Behavior();
			be.setId(id);
			be.setIdcard(idcard);
			
			be.setName(name);
			be.setIncident_date(incident_date);
			be.setIncident_location(incident_location);
			be.setDescription(description);
			be.setResult(result);
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			BadBehaviorDao.updateBehavior(be);
		}else if(oper.equals("add")){
			Behavior be=new Behavior();
			be.setIdcard(idcard);

			be.setName(name);
			be.setIncident_date(incident_date);
			be.setIncident_location(incident_location);
			be.setDescription(description);
			be.setResult(result);
			
			be.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			be.setModifi_user_id("1");
			be.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			be.setCreate_user_id("1");
			BadBehaviorDao.insertBehavior(be);
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIncident_date() {
		return incident_date;
	}
	public void setIncident_date(String incidentDate) {
		incident_date = incidentDate;
	}
	public String getIncident_location() {
		return incident_location;
	}
	public void setIncident_location(String incidentLocation) {
		incident_location = incidentLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
