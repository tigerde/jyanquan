package com.anquan.jy.entity;

/**
 * 安全里程
 * 
 * @author zhaotj
 * 
 */
public class SafetyDistance {
	private String id;
	private String idcard;// '身份证',
	private String bus_number;// '车号',
	private int year;// '年份',
	private int month;// '月份',
	private double mileage_month;// '本月安全里程',
	private double mileage_year;// '年度安全里程',
	private double mileage;// '累计安全里程',
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

}
