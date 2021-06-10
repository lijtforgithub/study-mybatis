package com.ljt.study.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.APIMapper;
import com.ljt.study.entity.Tag;
import com.ljt.study.entity.User;
import com.ljt.study.service.APIService;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午8:34:59
 */
public class APIServiceImpl implements APIService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public APIServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Tag> queryTag(int offset, int limit) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			APIMapper mapper = sqlSession.getMapper(APIMapper.class);
			
			return mapper.queryTag(new RowBounds(offset, limit));
		} 
	}

	@Override
	public User saveUser(User user) {
		if (null == user) {
			throw new NullPointerException("User 对象为空");
		}
		
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
			APIMapper mapper = sqlSession.getMapper(APIMapper.class);
			mapper.insertUser(user);
			
			return user;
		} 
	}

	@Override
	public User findUserById(Integer id) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			APIMapper mapper = sqlSession.getMapper(APIMapper.class);
			
			return mapper.getUserById(id);
		} 
	}
	
}
