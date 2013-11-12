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
}
