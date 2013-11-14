package com.anquan.jy.entity;

/**
 * 行为：良好、不良
 * @author zhaotj
 *
 */
public class Behavior {
	private String id;//
	private String idcard;// '身份证',
	private String name;// '姓名',
	private String incident_date;// '时间',
	private String incident_location;// '地点',
	private String description;// '经过',
	private String result;// '结果',
	private int type;// '行为类型：1良好行为，2不良行为',
	private String create_datetime;// NULL,
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
