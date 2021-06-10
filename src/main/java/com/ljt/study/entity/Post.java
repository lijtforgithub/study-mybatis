package com.ljt.study.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 博文
 * 
 * @author LiJingTang
 * @version 2015年9月26日 下午2:49:48
 */
public class Post implements Serializable {

	private static final long serialVersionUID = -1398472077336881385L;
	
	private int id;
	private Long createdOn;
	private String section;
	private String subject;
	private boolean draft;
	private String body;
	private Blog blog;
	private List<Comment> comments;
	private List<Tag> tags;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean isDraft() {
		return draft;
	}
	public void setDraft(boolean draft) {
		this.draft = draft;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", createdOn=" + createdOn + ", section=" + section + ", subject=" + subject + ", draft=" + draft + ", body=" + body + ", blog=" + blog + ", comments=" + comments + ", tags=" + tags + "]";
	}
	
}
