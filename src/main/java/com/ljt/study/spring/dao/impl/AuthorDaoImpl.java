package com.ljt.study.spring.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ljt.study.entity.Author;
import com.ljt.study.spring.dao.AuthorDao;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午7:38:22
 */
public class AuthorDaoImpl extends SqlSessionDaoSupport implements AuthorDao {

	@Override
	public Author getById(int id) {
		System.err.println("getById");
		return (Author) getSqlSession().selectOne("com.ljt.spring.dao.AuthorDao.getById", id);
	}
	
	public String getStatement(String sqlId) {
		StringBuffer sb = new StringBuffer();
		sb.append(super.getClass().getName());
		sb.append(".");
		sb.append(sqlId);

		return sb.toString();
	}

}
