package com.ljt.study.dao;

import com.ljt.study.entity.Engineer;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午10:15:31
 */
public interface EngineerMapper {
	
	int insert(Engineer engineer);
	
	Engineer getById(int id);

}
