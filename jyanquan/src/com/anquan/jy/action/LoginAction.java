package com.anquan.jy.action;

import com.anquan.jy.biz.UserBiz;
import com.anquan.jy.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String result="0";//返回登录结果：0失败，1登录成功
	
	public String login(){
		User user=UserBiz.checklogin(username, password);
		if(user!=null){
			result="1";
		}
		ActionContext.getContext().getSession().put("userid", user.getUser_id());
		ActionContext.getContext().getSession().put("name", user.getName());
		return SUCCESS;
	}

	 
	public void setUsername(String username) {
		this.username = username;
	}
 

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	 
}
