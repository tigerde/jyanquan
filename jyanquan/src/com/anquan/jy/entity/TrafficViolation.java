package com.anquan.jy.entity;

/**
 * 违章
 * @author zhaotj
 *
 */
public class TrafficViolation {
	
	private String id;
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
	private String create_datetime;//
	private String modifi_datetime;//
	private String create_user_id;// ,
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
