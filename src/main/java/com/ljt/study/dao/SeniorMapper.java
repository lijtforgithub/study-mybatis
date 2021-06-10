package com.ljt.study.dao;

import java.util.List;
import java.util.Map;

import com.ljt.study.entity.Author;
import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Car;
import com.ljt.study.entity.Comment;
import com.ljt.study.entity.Post;
import com.ljt.study.entity.Tag;
import com.ljt.study.entity.Vehicle;

/**
 * @author LiJingTang
 * @version 2015年9月27日 下午1:57:15
 */
public interface SeniorMapper {

	List<Blog> queryBlog();
	
	List<Blog> queryNestedQuery();
	
	List<Blog> queryNestedResult();
	
	List<Blog> selectBlog();
	
	Vehicle getVehicleById(int id);
	
	Car getCarById(int id);
	
	int insertBlog(Blog blog);
	
	int insertAuthor(Author author);
	
	int insertPost(Post post);
	
	int insertComment(Comment comment);
	
	int insertTag(Tag tag);
	
	int insertPostTag(List<Map<String, Integer>> relationList);
	
	int insertVehicle(Vehicle vehicle);
	
	int insertCar(Car car);
	
}
