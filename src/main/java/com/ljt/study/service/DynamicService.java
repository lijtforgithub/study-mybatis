package com.ljt.study.service;

import java.util.List;

import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Post;
import com.ljt.study.entity.Tag;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午6:09:25
 */
public interface DynamicService {
	
	Blog findBlogById(int id);
	
	List<Blog> queryBlogByTitle(String title);
	
	List<Post> queryPost(int[] ids);
	
	int saveTags(List<Tag> tagList);
	
	List<Blog> queryBlogBind(String title);

}
