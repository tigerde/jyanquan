package com.anquan.jy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import net.sf.json.JSONObject;

import com.anquan.jy.dao.RoleDao;
import com.anquan.jy.entity.Result;
import com.anquan.jy.entity.Role;
import com.anquan.jy.util.TimeFormatUtil;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RoleAction.class);
	private JSONObject json;
	private String id;// 用户登陆名
	private String rolestr;

	public String showrole() {
		List<Role> list=RoleDao.getRoles(id);
		net.sf.json.JSONArray jsona=net.sf.json.JSONArray.fromObject(list);
		json=new JSONObject();
		json.accumulate("role", jsona);
		json.accumulate("success", true);
		return SUCCESS;
	}

	public String editrole() {
		Result res = new Result();
		res.setResult(true);
		List<Role> list = new ArrayList<Role>();
		try {
			JSONArray ja = new JSONArray(rolestr);
			for (int i = 0; i < ja.length(); i++) {
				Role r = new Role();
				org.json.JSONObject jo = ja.getJSONObject(i);
				r.setUser_id(jo.getString("user_id"));
				r.setRole_value(jo.getBoolean("role_value") ? "1" : "0");
				r.setRole_name(jo.getString("role_name"));
				r.setCreate_datetime(TimeFormatUtil.getcurrentDate());
				r.setCreate_user_id("");
				list.add(r);
			}
			if (list.size() > 0 || id == null || "".equals(id)) {
				RoleDao.insertRole(list, id);
			} else {
				res.setResult(false);
			}

		} catch (JSONException e) {
			log.error("editrole权限保存错误" + id, e);
			res.setResult(false);
		}
		json = JSONObject.fromObject(res);
		return SUCCESS;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolestr() {
		return rolestr;
	}

	public void setRolestr(String rolestr) {
		this.rolestr = rolestr;
	}

}
