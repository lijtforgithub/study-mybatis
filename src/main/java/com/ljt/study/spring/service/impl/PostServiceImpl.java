package com.ljt.study.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljt.study.entity.Post;
import com.ljt.study.spring.dao.PostDao;
import com.ljt.study.spring.service.PostService;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午8:21:38
 */
@Service
public class PostServiceImpl implements PostService {
	
	@Resource(name="post_dao")
	private PostDao postDao;

	@Override
	public Post findById(int id) {
		return postDao.getById(id);
	}

}
