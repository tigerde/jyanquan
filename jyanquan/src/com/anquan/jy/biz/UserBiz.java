package com.anquan.jy.biz;

import com.anquan.jy.dao.AnquanDao;
import com.anquan.jy.entity.User;

public class UserBiz {
	public static User checklogin(String username,String password){
		User user=null;
			user=AnquanDao.checkLogin(username, password);
		return user;
	}
}
