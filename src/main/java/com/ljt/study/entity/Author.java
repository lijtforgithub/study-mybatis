package com.ljt.study.entity;

import java.io.Serializable;

/**
 * 作者
 * 
 * @author LiJingTang
 * @version 2015年9月26日 下午2:45:50
 */
public class Author implements Serializable {

	private static final long serialVersionUID = 1902140569109311056L;
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String bio;
	private String favouriteSection;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getFavouriteSection() {
		return favouriteSection;
	}
	public void setFavouriteSection(String favouriteSection) {
		this.favouriteSection = favouriteSection;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", bio=" + bio + ", favouriteSection=" + favouriteSection + "]";
	}
	
}
