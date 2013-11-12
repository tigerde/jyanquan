package com.anquan.jy.entity;

/**
 * 系统用户
 * @author zhaotj
 *
 */
public class User {
	private String id;//数据库id
	private String user_id;//用户登陆名
	private String password;//密码
	private String name;//昵称
	private String create_datetime;//创建时间
	private String modifi_datetime;//修改时间
	private int deleted;//是否删除：0正常，1删除

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}
