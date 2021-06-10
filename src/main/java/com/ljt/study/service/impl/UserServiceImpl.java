package com.ljt.study.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.UserMapper;
import com.ljt.study.entity.User;
import com.ljt.study.service.UserService;

/**
 * @author LiJingTang
 * @version 2015年9月27日 上午11:39:58
 */
public class UserServiceImpl implements UserService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User save(User user) {
		if (null == user) {
			throw new NullPointerException("User 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.insert(user);
			sqlSession.commit();
			
			return user;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public User findById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			return mapper.getById(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<User> query() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			
			return mapper.query();
		} finally {
			sqlSession.close();
		}
	}

}
