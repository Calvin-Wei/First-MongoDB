package com.wxc.mongodb.dao.impl;

import org.springframework.stereotype.Repository;

import com.wxc.mongodb.entity.UserInfo;

import com.wxc.mongodb.dao.IUserDao;

/**
 * 用户接口实现类
 * @author Administrator
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements IUserDao {

	@Override
	protected Class<UserInfo> getEntityClass() {
		return UserInfo.class;
	}
	
}
