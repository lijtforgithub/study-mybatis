package com.ljt.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Post;
import com.ljt.study.entity.Tag;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午5:58:47
 */
public interface DynamicMapper {
	
	Blog getBlogById(Integer id);
	
	List<Blog> queryBlogByTitle(@Param("title")String title); // 字符串不加@Param报错
	
	List<Post> queryPost(int[] ids);
	
	int insertTags(List<Tag> tagList);
	
	List<Blog> queryBlogBind(String title);

}
