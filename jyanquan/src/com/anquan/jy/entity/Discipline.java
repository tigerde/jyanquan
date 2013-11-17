package com.anquan.jy.entity;

/**
 * 
 * @author zhaotj
 * 驾驶员违章记录
 */
public class Discipline {

	private String id;
	private String idcard;// '身份证',
	private String position;// '职位',
	private String name;
	private String discipline_date;// '违章违纪时间',
	private String description;// '事由',
	private String gist;// '处罚依据',
	private String fine;// 罚款金额
	private String fine_number;// '罚款单号',
	private String create_datetime;// ,
	private String modifi_datetime;// ,
	private String create_user_id;// ,
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDiscipline_date() {
		return discipline_date;
	}

	public void setDiscipline_date(String disciplineDate) {
		discipline_date = disciplineDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGist() {
		return gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	public String getFine_number() {
		return fine_number;
	}

	public void setFine_number(String fineNumber) {
		fine_number = fineNumber;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
