package com.ljt.study;

import com.ljt.study.entity.*;
import com.ljt.study.enums.EngineerGrade;
import com.ljt.study.mybatis.MybatisUtils;
import com.ljt.study.service.*;
import com.ljt.study.service.impl.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.*;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午3:24:36
 */
public class MyBatisTest {
	
	private Random random = new Random();
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.loadSqlSessionFactory();
	
	@Test
	public void testBlog() {
		BlogService blogService = new BlogServiceImpl(sqlSessionFactory);
		
		Blog blog = blogService.save(getBlog());
		System.out.println(blogService.findById(blog.getId()));
		
//		System.out.println(blogService.query());
	}
	
	@Test
	public void testUser() {
		UserService userService = new UserServiceImpl(sqlSessionFactory);
		
		User user = userService.save(getUser());
		System.out.println(userService.findById(user.getId()));
		System.out.println(userService.query());
	}
	
	@Test
	public void testSeniorQuery() {
		SeniorService seniorService = new SeniorServiceImpl(sqlSessionFactory);
//		System.out.println(seniorService.queryBlog());
		
//		try {
//			List<Blog> blogList = seniorService.queryNestedQuery();
//			Thread.sleep(2000);
//			blogList.get(0).getAuthor(); // 配合懒加载使用
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		long startTime = System.currentTimeMillis();
//		seniorService.queryNestedQuery();
//		seniorService.queryNestedResult();
//		System.out.println(System.currentTimeMillis() - startTime);
		
		System.out.println(seniorService.selectBlog());
	}
	
	@Test
	public void testSeniorInsert() {
		SeniorService seniorService = new SeniorServiceImpl(sqlSessionFactory);
		
		for (int i = 0; i < 2; i++) {
			Map<Post, Tag> relationMap = new HashMap<>(1);
			
			Blog blog = seniorService.saveBlog(getBlog());
			Post post = seniorService.savePost(getPost(blog));
			seniorService.saveComment(getComment(post));
			Tag tag = seniorService.saveTag(getTag());
			
			relationMap.put(post, tag);
			seniorService.addPostTagRelation(relationMap);
		}
	}
	
	@Test
	public void testDiscriminator() {
		SeniorService seniorService = new SeniorServiceImpl(sqlSessionFactory);
		
		Vehicle vehicle = seniorService.saveVehicle(getVehicle());
		System.out.println(seniorService.findVehicleById(vehicle.getId()).getClass());
		
		Car car = seniorService.saveCar(getCar());
		System.out.println(seniorService.findCarById(car.getId()));
	}
	
	@Test
	public void testEnumTypeHandler() {
		EngineerService engineerService = new EngineerServiceImpl(sqlSessionFactory);
		Engineer engineer = engineerService.save(getEngineer());
		
		System.out.println(engineerService.findById(engineer.getId()));
	}
	
	@Test
	public void testDynamic() {
		DynamicService dynamicService = new DynamicServiceImpl(sqlSessionFactory);
		
		System.out.println(dynamicService.queryBlogByTitle("title_%").size());
		System.out.println(dynamicService.findBlogById(1));
		System.out.println(dynamicService.queryPost(new int[] {1}));
		
		List<Tag> tagList = new ArrayList<>(3);
		for (int i = 0; i < 3; i++) {
			tagList.add(getTag());
		}
		System.out.println(dynamicService.saveTags(tagList));
		
		System.out.println(dynamicService.queryBlogBind("title"));
		
	}
	
	@Test
	public void testAPI() {
		APIService apiService = new APIServiceImpl(sqlSessionFactory);
		
		System.out.println(apiService.queryTag(10, 3));
//		User user = apiService.saveUser(getUser());
//		System.out.println(apiService.findUserById(user.getId()));
	}
	
	private Engineer getEngineer() {
		Engineer engineer = new Engineer();
		engineer.setName("name_" + random.nextInt(1000));
		engineer.setPassword("password_" + random.nextInt(1000));
		engineer.setGrade(EngineerGrade.SENIOR);
		
		return engineer;
	}
	
	private User getUser() {
		User user = new User();
		user.setName("name_" + random.nextInt(1000));
		user.setPassword("password_" + random.nextInt(1000));
		
		return user;
	}
	
	private Vehicle getVehicle() {
		Vehicle vehicle = new SUV();
		vehicle.setColor("color_" + random.nextInt(10000));
		vehicle.setMake("make_" + random.nextInt(10000));
		vehicle.setModel("model_" + random.nextInt(10000));
		vehicle.setVin("vin_" + random.nextInt(10000));
		vehicle.setYear("2015");
		
		return vehicle;
	}
	
	private Car getCar() {
		Car car = new Car();
		car.setColor("color_" + random.nextInt(10000));
		car.setMake("make_" + random.nextInt(10000));
		car.setModel("model_" + random.nextInt(10000));
		car.setVin("vin_" + random.nextInt(10000));
		car.setYear("2015");
		car.setDoorCount(4);
		
		return car;
	}
	
	private Blog getBlog() {
		Blog blog = new Blog();
		blog.setTitle("title_" + random.nextInt(10000));
		blog.setAuthor(getAuthor());
		
		return blog;
	}
	
	private Author getAuthor() {
		Author author = new Author();
		author.setBio("bio_" + random.nextInt(10000));
		author.setEmail("email_" + random.nextInt(1000));
		author.setFavouriteSection("favouriteSection_" + random.nextInt(10000));
		author.setPassword("password_" + random.nextInt(10000));
		author.setUsername("username_" + random.nextInt(10000));
		
		return author;
	}
	
	private Post getPost(Blog blog) {
		Post post = new Post();
		post.setBlog(blog);
		post.setBody("body_" + random.nextInt(10000));
		post.setCreatedOn(System.currentTimeMillis());
		post.setDraft(true);
		post.setSection("section_" + random.nextInt(10000));
		post.setSubject("subject_" + random.nextInt(10000));
		
		return post;
	}
	
	private Comment getComment(Post post) {
		Comment comment = new Comment();
		comment.setName("name_" + random.nextInt(10000));
		comment.setText("text_" + random.nextInt(10000));
		comment.setPost(post);
		
		return comment;
	}
	
	private Tag getTag() {
		Tag tag = new Tag();
		tag.setName("name_" + random.nextInt(10000));
		
		return tag;
	}

}
