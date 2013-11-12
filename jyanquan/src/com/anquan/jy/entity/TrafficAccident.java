package com.anquan.jy.entity;

/**
 * 
 * @author zhaotj 交通事故
 */
public class TrafficAccident {
	private String id;
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
	private String create_datetime;//
	private String modifi_datetime;//
	private String create_user_id;//
	private String modifi_user_id;//
	private int deleted;//

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
