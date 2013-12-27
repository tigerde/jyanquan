package com.anquan.jy.action;

import net.sf.json.JSONObject;

import com.anquan.jy.biz.DriverBiz;
import com.anquan.jy.biz.DriverInfoBiz;
import com.anquan.jy.biz.UserBiz;
import com.anquan.jy.dao.TrafficAccidentDao;
import com.anquan.jy.dao.TrafficViolationDao;
import com.anquan.jy.dao.UserDao;
import com.anquan.jy.entity.Driver;
import com.anquan.jy.entity.TrafficAccident;
import com.anquan.jy.entity.User;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;// 页码
	private int pageSize;// 页值
	private String sidx;// 排序字段
	private String sord;// 排序方式 asc /desc
	private boolean _search = false;// 是否搜索 true false
	private String oper; // 增删改判断标记
	private String id;
	private JSONObject json;

	private String user_id;// 用户登陆名
	private String password;// 密码
	private String name;// 昵称
	private String create_datetime;// 创建时间
	private String modifi_datetime;// 修改时间
	private int deleted;// 是否删除：0正常，1删除

	public String showUser() {
		
		return SUCCESS;
	}
	public String getUser() {
		json = UserBiz.getUsers(pageNo, pageSize, sidx, sord);
		return SUCCESS;
	}

	/**
	 * 编辑驾驶员交通事故信息
	 */
	public void editUser() {
		ActionContext.getContext().getSession().get("userid");
		//put("userid", user.getUser_id());
		if (oper.equals("del")) {
			// 删除
			UserDao.delUser(id);

		} else if (oper.equals("edit")) {
			// 编辑
			User ta = new User();
			ta.setId(id);
			ta.setUser_id(user_id);
			ta.setName(name);
			ta.setPassword(password);
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			UserDao.updateUser(ta);
		} else if (oper.equals("add")) {
			User ta = new User();
			ta.setId(id);
			ta.setUser_id(user_id);
			ta.setName(name);
			ta.setPassword(password);
			ta.setModifi_datetime(TimeFormatUtil.getcurrentTime());
			ta.setCreate_datetime(TimeFormatUtil.getcurrentTime());
			UserDao.insertUser(ta);
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public boolean is_search() {
		return _search;
	}

	public void set_search(boolean search) {
		_search = search;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public JSONObject getJson() {
		return json;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
