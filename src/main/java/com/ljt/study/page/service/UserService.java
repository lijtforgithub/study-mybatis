package com.ljt.study.page.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午8:53:30
 */
public interface UserService {
	
	PageInfo<User> query(Page<User> page);

}
