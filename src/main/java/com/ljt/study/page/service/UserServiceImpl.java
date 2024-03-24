package com.ljt.study.page.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljt.study.entity.User;
import com.ljt.study.spring.dao.UserDao;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJingTang
 * @version 2015年9月29日 下午8:56:00
 */
@Service("pageUserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public PageInfo<User> query(Page<User> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());  //紧跟着的第一个select方法会被分页
		List<User> list = userDao.query();
//		List<User> list = queryUser(page);

		return new PageInfo<>(list);
	}
	
	@SuppressWarnings("unused")
	private List<User> queryUser(Page<User> page) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			return sqlSession.selectList("com.ljt.study.spring.dao.UserDao.query", null, new RowBounds(page.getPageNum(), page.getPageSize()));
		}
	}

}
