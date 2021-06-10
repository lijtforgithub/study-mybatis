package com.ljt.study.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ljt.study.entity.User;

/**
 * @author LiJingTang
 * @version 2015年9月28日 下午10:35:21
 */
public interface UserDao {
	
//	@Select("SELECT * FROM T_USER WHERE id = #{id}")
	User getById(int id);
	
	List<User> query();
	
	/**
	 * 接口中有的方法XML中没有 调用的时候才会报错
	 */
	List<Map<String, Object>> queryUser(@Param("id") Integer id);

}
