package com.ljt.study.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljt.study.entity.Blog;
import com.ljt.study.spring.dao.BlogDao;
import com.ljt.study.spring.service.BlogService;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午7:13:48
 */
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;

	@Override
	public Blog save(Blog blog) {
		if (null == blog) {
			throw new NullPointerException("Blog 对象为空");
		}
		
		blogDao.insert(blog);
		
		return blog;
	}

	@Override
	public Blog findById(int id) {
		return blogDao.getById(id);
	}

}
