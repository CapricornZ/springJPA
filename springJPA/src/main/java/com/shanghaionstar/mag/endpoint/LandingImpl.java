package com.shanghaionstar.mag.endpoint;

import cn.ibeans.dao.UserDao;
import cn.ibeans.web.model.User;

public class LandingImpl implements Landing {

	cn.ibeans.dao.UserDao userDao;
	public void setUserDao(UserDao dao){
		this.userDao = dao;
	}
	
	@Override
	public String GetLandingpage(String request) {

		return this.userDao.findByName(request).getPassword();
	}

	@Override
	public String SaveLandingpage(String request) {
		
		User user = new User();
		user.setPassword("123456");
		user.setUsername("somp");
		this.userDao.saveOrUpdate(user);
		return "OK";
	}
}
