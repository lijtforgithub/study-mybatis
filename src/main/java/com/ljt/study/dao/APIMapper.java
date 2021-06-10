package com.ljt.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.session.RowBounds;

import com.ljt.study.entity.Blog;
import com.ljt.study.entity.Tag;
import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午8:31:52
 */
public interface APIMapper {
	
	/**
	 * 全查询出来，然后根据结果集的下标截取
	 * @param rowBounds 允许你限制返回行数的范围,或者提供自定 义结果控制逻辑,这通常用于大量的数据集合。 
	 */
	@Flush
	@Select("SELECT * FROM T_TAG")
	List<Tag> queryTag(RowBounds rowBounds);
	
	/**
	 * 如果设置为 before=true，那么它会首先选择主键，设置 keyProperty 然后执行插入语句。对象的属性值不会赋值
	 * 如果设置为 before=false，那么先执行插入语句，然后是 selectKey 元素。对象的属性值会赋值
	 */
	@Insert("INSERT INTO T_USER (name, password) VALUES (#{name}, #{password})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=int.class)
	int insertUser(User user);
	
	@Results({
		@Result(property="id", column="id", id=true),
		@Result(property="name", column="name"),
		@Result(property="password", column="password")
	})
	@Select("SELECT * FROM T_USER WHERE id = #{id}")
	User getUserById(Integer id);

	@Results
	@ConstructorArgs({
		@Arg(column="id", id=true), //参数是按顺序 排列
		@Arg(column="title")
	})
	@Select("SELECT * FROM T_BLOG where id = #{id}")
	Blog getBlogById(Integer id);

}
