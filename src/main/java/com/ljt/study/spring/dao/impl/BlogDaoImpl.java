package com.ljt.study.spring.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.ljt.study.entity.Blog;
import com.ljt.study.spring.dao.BlogDao;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午6:50:54
 */
public class BlogDaoImpl implements BlogDao {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(Blog blog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Blog getById(int id) {
		return (Blog) sqlSession.selectOne("com.ljt.spring.dao.BlogDao.getById", id);
	}
	
}
