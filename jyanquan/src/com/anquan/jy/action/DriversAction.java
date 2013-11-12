package com.anquan.jy.action;

import com.anquan.jy.biz.DriverBiz;
import com.anquan.jy.entity.Driver;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DriversAction extends ActionSupport {

	/**
	 * _search => [ false ] nd => [ 1382807833879 ] pageNo => [ 1 ] pageSize =>
	 * [ 20 ] sidx => [ id ] sord => [ asc ] company => [ 6 ] idcard => [ 3 ]
	 * line_number => [ 5 ] mobile_phone => [ 4 ] name => [ 1 ] sex => [ 2 ]
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;// 页码
	private int pageSize;// 页值
	private String sidx;// 排序字段
	private String sord;// 排序方式 asc /desc
	private boolean _search=false;// 是否搜索 true false
	private String oper; // 增删改判断标记
	private String id;
	private String idcard="";
	private String line_number="";
	private String mobile_phone="";
	private String name="";
	private String company="";
	private String sex="";
	private String birth="";
	private String staffid="";
	private String homep_hone="";
	private String bus_number="";
	private String driving_type="";
	private String pass_time="";
	
	
	

	private JSONObject json;

	public String search() {
		return SUCCESS;
	}

	public String getdrivers() {
		String search="";
		if(_search){
			search=" and idcard like '%"+idcard+"%' and line_number like '%"+line_number+"%' and mobile_phone like '%"+mobile_phone+"%' and name like '%"+name+"%' and company like '%"+company+"%' and sex like '%"+sex+"%'";
			//System.out.println(search);
		}
		json = DriverBiz.getDrivers(pageNo, pageSize, sidx, sord,search);
		return SUCCESS;
	}
	
	public String driverinfo(){
		json=DriverBiz.getDriver(id);
		return SUCCESS;
	}
	public String showinfo(){
		return SUCCESS;
	}
	
	public void driveredit(){
		/*if (oper.equals("del")){
			
		// 增加方法
		}else if (oper.equals("add")){
			 
		// 修改方法
		}else if (oper.equals("edit")) {
			
		}*/
		if (oper.equals("del")){
			//删除
			//DriverBiz.delDriver(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			Driver driver=new Driver();
			driver.setId(id);
			driver.setStaffid(staffid);
			driver.setName(name);
			driver.setIdcard(idcard);
			driver.setSex(sex);
			driver.setBirth(birth);
			driver.setMobile_phone(mobile_phone);
			driver.setHome_phone(homep_hone);
			driver.setLine_number(line_number);
			driver.setBus_number(bus_number);
			driver.setDriving_type(driving_type);
			driver.setPass_time(pass_time);
			driver.setCompany(company);
			driver.setModifi_user_id("");
			driver.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			DriverBiz.updateDriver(driver);
		}
		 
	}
	public void driversimpleedit(){
		
		if (oper.equals("del")){
			//删除
			DriverBiz.delDriver(id);
			
		}else if (oper.equals("edit")) {
			//编辑
			Driver driver=new Driver();
			driver.setId(id);
			driver.setStaffid(staffid);
			driver.setName(name);
			driver.setIdcard(idcard);
			driver.setSex(sex);
			driver.setBirth(birth);
			driver.setMobile_phone(mobile_phone);
			driver.setHome_phone(homep_hone);
			driver.setLine_number(line_number);
			driver.setBus_number(bus_number);
			driver.setDriving_type(driving_type);
			driver.setPass_time(pass_time);
			driver.setCompany(company);
			driver.setModifi_user_id("");
			driver.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			DriverBiz.updateDriver(driver);
		}else if(oper.equals("add")){
			Driver driver=new Driver();
			driver.setId(id);
			driver.setStaffid(staffid);
			driver.setName(name);
			driver.setIdcard(idcard);
			driver.setSex(sex);
			driver.setBirth(birth);
			driver.setMobile_phone(mobile_phone);
			driver.setHome_phone(homep_hone);
			driver.setLine_number(line_number);
			driver.setBus_number(bus_number);
			driver.setDriving_type(driving_type);
			driver.setPass_time(pass_time);
			driver.setCompany(company);
			driver.setModifi_user_id("");
			driver.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			driver.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			driver.setCreate_user_id("");
			DriverBiz.insertDriver(driver);
		}
		
	}
	
	
	
	
	
	
	

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSidx() {
		return sidx;
	}

	
	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSord() {
		return sord;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getLine_number() {
		return line_number;
	}

	public void setLine_number(String lineNumber) {
		line_number = lineNumber;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobilePhone) {
		mobile_phone = mobilePhone;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void set_search(boolean _search) {
		this._search = _search;
	}

	public boolean is_search() {
		return _search;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public void setHomep_hone(String homep_hone) {
		this.homep_hone = homep_hone;
	}

	public String getHomep_hone() {
		return homep_hone;
	}

	public String getBus_number() {
		return bus_number;
	}

	public void setBus_number(String busNumber) {
		bus_number = busNumber;
	}

	public String getDriving_type() {
		return driving_type;
	}

	public void setDriving_type(String drivingType) {
		driving_type = drivingType;
	}

	public String getPass_time() {
		return pass_time;
	}

	public void setPass_time(String passTime) {
		pass_time = passTime;
	}
	
	
	
}
