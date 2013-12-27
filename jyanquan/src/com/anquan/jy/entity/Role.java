package com.anquan.jy.entity;

public class Role {
	private String id;//id
	private String user_id;//用户系统id
	private String role_name;//规则名称
	private String role_value;//规则值1有效、0无效
	private String create_datetime;
	private String create_user_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getRole_value() {
		return role_value;
	}

	public void setRole_value(String roleValue) {
		role_value = roleValue;
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String createDatetime) {
		create_datetime = createDatetime;
	}

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String createUserId) {
		create_user_id = createUserId;
	}

}
