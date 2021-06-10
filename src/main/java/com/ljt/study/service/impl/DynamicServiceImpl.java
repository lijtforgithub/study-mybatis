package com.ljt.study.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.DynamicMapper;
import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Post;
import com.ljt.study.entity.Tag;
import com.ljt.study.service.DynamicService;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午6:11:05
 */
public class DynamicServiceImpl implements DynamicService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public DynamicServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Blog findBlogById(int id) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			
			return mapper.getBlogById(id);
		} 
	}
	
	@Override
	public List<Blog> queryBlogByTitle(String title) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			
			return mapper.queryBlogByTitle(title);
		} 
	}

	@Override
	public List<Post> queryPost(int[] ids) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			
			return mapper.queryPost(ids);
		} 
	}

	@Override
	public int saveTags(List<Tag> tagList) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) { // 这是true自动提交
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			
			return mapper.insertTags(tagList);
		} 
	}

	@Override
	public List<Blog> queryBlogBind(String title) {
		try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
			DynamicMapper mapper = sqlSession.getMapper(DynamicMapper.class);
			
			return mapper.queryBlogBind(title);
		} 
	}
	
}
