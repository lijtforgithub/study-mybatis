package com.ljt.study.service;

import java.util.List;

import com.ljt.study.entity.Tag;
import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午8:34:27
 */
public interface APIService {
	
	List<Tag> queryTag(int offset, int limit);
	
	User saveUser(User user);
	
	User findUserById(Integer id);

}
