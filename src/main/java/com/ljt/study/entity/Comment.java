package com.ljt.study.entity;

import java.io.Serializable;

/**
 * 评论
 * 
 * @author LiJingTang
 * @version 2015年9月27日 下午1:19:31
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String text;
	private Post post;
	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", text=" + text + ", post=" + post + "]";
	}
	
}
