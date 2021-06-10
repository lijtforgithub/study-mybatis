package com.ljt.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ljt.study.entity.Blog;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午2:24:51
 */
public interface BlogMapper {
	
	int insert(Blog blog);
	
	/**
	 * 对于简单语句来说，注解使代码显得更加简洁，然而 Java 注解对于稍微复杂的语句就会力不从心并且会显得更加混乱。
	 * 因此，如果你需要做很复杂的事情，那么最好使用 XML 来映射语句。
	 */
	@Select("SELECT * FROM t_blog WHERE id = #{id}")
	Blog getById(int id);
	
	List<Blog> query();

}
