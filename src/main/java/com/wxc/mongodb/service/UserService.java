package com.wxc.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxc.mongodb.dao.IBaseDao;
import com.wxc.mongodb.dao.IUserDao;
import com.wxc.mongodb.entity.UserInfo;

@Service
public class UserService extends BaseService<UserInfo> {
	@Autowired
	private IUserDao userDao;

	@Override
	protected IBaseDao<UserInfo> getDao() {
		return userDao;
	}

}
