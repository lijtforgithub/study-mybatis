package com.ljt.study.spring.dao;

import org.springframework.stereotype.Repository;

import com.ljt.study.entity.Post;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午8:19:34
 */
@Repository("post_dao")
public interface PostDao {
	
	Post getById(int id);

}
