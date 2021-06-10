package com.ljt.study.spring.dao;

import com.ljt.study.entity.Blog;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午6:46:47
 */
public interface BlogDao {
	
	int insert(Blog blog);
	
	Blog getById(int id);

}
