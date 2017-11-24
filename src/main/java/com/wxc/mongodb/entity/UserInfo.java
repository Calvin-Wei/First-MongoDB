package com.wxc.mongodb.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.wxc.mongodb.annotation.AutoIncKey;

@Document(collection = "userInfo_auto")
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7359939619554938312L;
	@AutoIncKey
	@Id
	private Long id = 0L;
	@Field
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
