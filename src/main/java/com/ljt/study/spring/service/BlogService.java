package com.ljt.study.spring.service;

import com.ljt.study.entity.Blog;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午7:12:59
 */
public interface BlogService {
	
	Blog save(Blog blog);
	
	Blog findById(int id);

}
