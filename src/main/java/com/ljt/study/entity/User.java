package com.ljt.study.entity;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @version 2015年9月27日 上午11:08:30
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6953397958310097535L;
	
	private int id;
	private String name;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
