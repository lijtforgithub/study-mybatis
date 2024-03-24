package com.ljt.study;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ljt.study.entity.User;
import com.ljt.study.spring.service.AuthorService;
import com.ljt.study.spring.service.BlogService;
import com.ljt.study.spring.service.PostService;
import com.ljt.study.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

/**
 * junit5 使用 @SpringJUnitConfig
 * @author LiJingTang
 * @version 2015年9月28日 下午9:44:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MybatisSpringTest {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private PostService postService;
	@Autowired
	private com.ljt.study.page.service.UserService pageUserService;
	
	@Test
	public void testMapperFactoryBean() {
		System.out.println(userService.findById(2));
	}
	
	@Test
	public void testSqlSessionTemplate() {
		System.out.println(blogService.findById(2));
	}
	
	@Test
	public void testSqlSessionDaoSupport() {
		System.out.println(authorService.findById(2));
	}
	
	@Test
	public void testMapperScannerConfigurer() {
		System.out.println(postService.findById(2));
	}
	
	@Test
	public void testPageHelper() {
		Page<User> page = new Page<>(3, 2);
		PageInfo<User> pageInfo = pageUserService.query(page);
		
		System.out.println(pageInfo.getTotal() + " - " + pageInfo.getPages());
		if (!CollectionUtils.isEmpty(pageInfo.getList())) {
			for (User user : pageInfo.getList()) {
				System.out.println(user);
			}
		}
	}
	
}
