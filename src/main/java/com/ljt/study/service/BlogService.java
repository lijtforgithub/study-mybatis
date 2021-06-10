package com.ljt.study.service;

import java.util.List;

import com.ljt.study.entity.Blog;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午2:33:49
 */
public interface BlogService {
	
	Blog save(Blog blog);
	
	Blog findById(int id);
	
	List<Blog> query();

}
