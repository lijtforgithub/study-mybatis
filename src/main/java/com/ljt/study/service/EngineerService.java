package com.ljt.study.service;

import com.ljt.study.entity.Engineer;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午10:20:09
 */
public interface EngineerService {
	
	Engineer save(Engineer engineer);
	
	Engineer findById(int id);


}
