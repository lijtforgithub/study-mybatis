package com.ljt.study.service;

import java.util.List;

import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月27日 上午11:37:44
 */
public interface UserService {
	
	User save(User user);
	
	User findById(int id);
	
	List<User> query();

}
