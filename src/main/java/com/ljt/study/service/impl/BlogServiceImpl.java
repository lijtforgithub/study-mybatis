package com.ljt.study.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.BlogMapper;
import com.ljt.study.entity.Blog;
import com.ljt.study.service.BlogService;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午2:34:36
 */
public class BlogServiceImpl implements BlogService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BlogServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Blog save(Blog blog) {
		if (null == blog) {
			throw new NullPointerException("Blog 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert("com.ljt.dao.BlogMapper.insert", blog);
			sqlSession.commit();
			
			return blog;
		} finally {
			sqlSession.close();
		}
	}

	public Blog findById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			
			return mapper.getById(id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Blog> query() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			
			return mapper.query();
		} finally {
			sqlSession.close();
		}
	}
	
}
