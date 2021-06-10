package com.ljt.study.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 博客
 * 
 * @author LiJingTang
 * @version 2015年9月26日 下午2:22:47
 */
@Alias("blog")
public class Blog implements Serializable  {
	
	private static final long serialVersionUID = 3072434293687069244L;
	
	private int id;
	private String title;
	private Author author;
	private Author coAuthor;
	private List<Post> posts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Author getCoAuthor() {
		return coAuthor;
	}
	public void setCoAuthor(Author coAuthor) {
		this.coAuthor = coAuthor;
	}
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author + ", coAuthor=" + coAuthor + ", posts=" + posts + "]";
	}
	
}
