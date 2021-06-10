package com.ljt.study.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljt.study.entity.Author;
import com.ljt.study.spring.dao.AuthorDao;
import com.ljt.study.spring.service.AuthorService;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午7:46:07
 */
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorDao authorDao;

	@Override
	public Author findById(int id) {
		return authorDao.getById(id);
	}

}
