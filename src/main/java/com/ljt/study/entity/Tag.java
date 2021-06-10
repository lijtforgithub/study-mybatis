package com.ljt.study.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 标签
 * 
 * @author LiJingTang
 * @version 2015年9月27日 下午1:24:40
 */
public class Tag implements Serializable {

	private static final long serialVersionUID = 6095134068284283706L;
	
	private int id;
	private String name;
	private List<Post> posts;
	
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
}
