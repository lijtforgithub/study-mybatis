package com.ljt.study.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.EngineerMapper;
import com.ljt.study.dao.UserMapper;
import com.ljt.study.entity.Engineer;
import com.ljt.study.service.EngineerService;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午10:20:53
 */
public class EngineerServiceImpl implements EngineerService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public EngineerServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Engineer save(Engineer engineer) {
		if (null == engineer) {
			throw new NullPointerException("Engineer 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.insert(engineer);
			EngineerMapper engMapper = sqlSession.getMapper(EngineerMapper.class);
			engMapper.insert(engineer);
			sqlSession.commit();
			
			return engineer;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Engineer findById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			EngineerMapper mapper = sqlSession.getMapper(EngineerMapper.class);
			
			return mapper.getById(id);
		} finally {
			sqlSession.close();
		}
	}

}
