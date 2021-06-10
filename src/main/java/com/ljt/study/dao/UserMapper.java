package com.ljt.study.dao;

import java.util.List;

import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月27日 上午11:10:09
 */
public interface UserMapper {
	
	int insert(User user);
	
	User getById(int id);
	
	List<User> query();

}
