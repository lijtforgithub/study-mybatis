package com.ljt.study.service;

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
 * @version 2015年9月27日 下午1:58:14
 */
public interface SeniorService {
	
	List<Blog> queryBlog();
	
	List<Blog> queryNestedQuery();
	
	List<Blog> queryNestedResult();
	
	List<Blog> selectBlog();
	
	Blog saveBlog(Blog blog);
	
	Author saveAuthor(Author author);
	
	Post savePost(Post post);
	
	Comment saveComment(Comment comment);
	
	Tag saveTag(Tag tag);
	
	void addPostTagRelation(Map<Post, Tag> relationMap);
	
	Vehicle saveVehicle(Vehicle vehicle);
	
	Vehicle findVehicleById(int id);
	
	Car saveCar(Car car);
	
	Car findCarById(int id);

}
