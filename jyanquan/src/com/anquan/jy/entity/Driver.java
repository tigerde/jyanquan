package com.anquan.jy.entity;

/**
 * 驾驶员
 * @author zhaotj
 *
 */
public class Driver {
	private String id;// id
	private String staffid;//工号
	private String name;// '姓名',
	private String idcard;// '身份证',
	private String sex;// '性别',
	private String birth;// '生日',
	private String driver_id;// '驾驶证号',
	private String mobile_phone;// '手机',
	private String home_phone;// '家庭电话',
	private String line_number;// '线路',
	private String bus_number;// '车牌号',
	private String driving_type;// '准驾车型',
	private String pass_time;// '取得A3或A1资格时间',
	private String company;// '所在分公司',
	private String create_datetime;//
	private String modifi_datetime;//
	private String create_user_id;//
	private String modifi_user_id;//
	private int deleted;// '是否删除：1删除，0未删除',

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driverId) {
		driver_id = driverId;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobilePhone) {
		mobile_phone = mobilePhone;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String homePhone) {
		home_phone = homePhone;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String createDatetime) {
		create_datetime = createDatetime;
	}

	public String getModifi_datetime() {
		return modifi_datetime;
	}

	public void setModifi_datetime(String modifiDatetime) {
		modifi_datetime = modifiDatetime;
	}

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String createUserId) {
		create_user_id = createUserId;
	}

	public String getModifi_user_id() {
		return modifi_user_id;
	}

	public void setModifi_user_id(String modifiUserId) {
		modifi_user_id = modifiUserId;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getStaffid() {
		return staffid;
	}

}
