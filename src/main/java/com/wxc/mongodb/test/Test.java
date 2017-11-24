package com.wxc.mongodb.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wxc.mongodb.entity.UserInfo;
import com.wxc.mongodb.service.UserService;
import com.wxc.mongodb.util.PageModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {
	@Autowired
	private UserService service;

	@org.junit.Test
	public void save() {
		UserInfo userInfo = new UserInfo();
		userInfo.setName("张三");
		service.save(userInfo);
		System.out.println("已生成ID:" + userInfo.getId());
	}
	
	@org.junit.Test
	public void findAll() {
		List<UserInfo> list=service.findAll();
		for(UserInfo u:list) {
			System.out.println(u.getName());
		}
	}
	@org.junit.Test
	public void find() {
		UserInfo user=service.find(1L);
		System.out.println(user.getName());
	}
	
	@org.junit.Test
	public void update() {
		UserInfo user=service.find(1L);
		user.setName("Test_Update");
		service.update(user);
	}
	@org.junit.Test
	public void delete() {
		service.delete(2L);
	}
	@org.junit.Test
	public void pageAll() {
		PageModel<UserInfo> page=service.pageAll(1, 10);
		System.out.println("总记录："+page.getTotalCount()+",总页数："+page.getTotalPage());
		for(UserInfo u:page.getList()) {
			System.out.println(u.getName());
		}
	}
	
}
