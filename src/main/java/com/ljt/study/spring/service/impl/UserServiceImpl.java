package com.ljt.study.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljt.study.entity.User;
import com.ljt.study.spring.dao.UserDao;
import com.ljt.study.spring.service.UserService;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午10:44:15
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findById(int id) {
		System.err.println(userDao.queryUser(10));
		return userDao.getById(id);
	}

}
