package com.ljt.study.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ljt.study.dao.SeniorMapper;
import com.ljt.study.entity.Author;
import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Car;
import com.ljt.study.entity.Comment;
import com.ljt.study.entity.Post;
import com.ljt.study.entity.Tag;
import com.ljt.study.entity.Vehicle;
import com.ljt.study.service.SeniorService;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午1:58:51
 */
public class SeniorServiceImpl implements SeniorService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public SeniorServiceImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Blog> queryBlog() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.queryBlog();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<Blog> queryNestedQuery() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.queryNestedQuery();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Blog> queryNestedResult() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.queryNestedResult();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<Blog> selectBlog() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.selectBlog();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Blog saveBlog(Blog blog) {
		if (null == blog) {
			throw new NullPointerException("Blog 对象为空");
		}
		if (null == blog.getAuthor()) {
			throw new NullPointerException("Author 对象为空");
		}
		if (0 == blog.getAuthor().getId()) {
			this.saveAuthor(blog.getAuthor());
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertBlog(blog);
			sqlSession.commit();
			
			return blog;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Author saveAuthor(Author author) {
		if (null == author) {
			throw new NullPointerException("Author 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertAuthor(author);
			sqlSession.commit();
			
			return author;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Post savePost(Post post) {
		if (null == post) {
			throw new NullPointerException("Post 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertPost(post);
			sqlSession.commit();
			
			return post;
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public Comment saveComment(Comment comment) {
		if (null == comment) {
			throw new NullPointerException("Comment 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertComment(comment);
			sqlSession.commit();
			
			return comment;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Tag saveTag(Tag tag) {
		if (null == tag) {
			throw new NullPointerException("Tag 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertTag(tag);
			sqlSession.commit();
			
			return tag;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void addPostTagRelation(Map<Post, Tag> relationMap) {
		if (null == relationMap || relationMap.isEmpty()) {
			return;
		}
		
		List<Map<String, Integer>> mapList = new ArrayList<>(relationMap.size());
		
		for (Entry<Post, Tag> entry : relationMap.entrySet()) {
			if (null == entry.getValue()) {
				throw new NullPointerException(entry.getValue() + " 的Tag 对象为空");
			}
			
			Map<String, Integer> map = new HashMap<>(2);
			map .put("postId", entry.getKey().getId());
			map.put("tagId", entry.getValue().getId());
			
			mapList.add(map);
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertPostTag(mapList);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		if (null == vehicle) {
			throw new NullPointerException("Vehicle 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertVehicle(vehicle);
			sqlSession.commit();
			
			return vehicle;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Vehicle findVehicleById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.getVehicleById(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Car saveCar(Car car) {
		if (null == car) {
			throw new NullPointerException("Car 对象为空");
		}
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			mapper.insertVehicle(car);
			mapper.insertCar(car);
			sqlSession.commit();
			
			return car;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Car findCarById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try {
			SeniorMapper mapper = sqlSession.getMapper(SeniorMapper.class);
			
			return mapper.getCarById(id);
		} finally {
			sqlSession.close();
		}
	}
	
}
