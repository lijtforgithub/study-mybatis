/**
 * @author LiJingTang
 * @version 2015年9月28日 下午9:43:14
 */
package com.ljt.study.spring;

/**
 	SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	SqlSessionFactory sessionFactory = factoryBean.getObject();
	
  	SqlSessionFactory 有一个单独的必须属性,就是 JDBC 的 DataSource。这可以是任意 的 DataSource,其配置应该和其它 Spring 数据库连接是一样的。 
	一个通用的属性是 configLocation,它是用来指定 MyBatis 的 XML 配置文件路径的。 如果基本的 MyBatis 配置需要改变, 那么这就是一个需要它的地方。 
		通常这会是<settings> 或<typeAliases>的部分。 
	要注意这个配置文件不需要是一个完整的 MyBatis 配置。确切地说,任意环境,数据源 和 MyBatis 的事务管理器都会被忽略。
		SqlSessionFactoryBean 会创建它自己的,使用这些 值定制 MyBatis 的 Environment 时是需要的。 
	如果 XML文件在类路径的 位置和Mapper接口相同时, 它会被 MapperFactoryBean 自动解析。 没有必要在 MyBatis配置XML文件路径(接口名字和XML文件名一致)
	如果 MyBatis 映射器 XML 文件在和映射器类相同的路径下不存在,那么另外一个需要 配置文件的原因就是它了。
		使用这个配置,有两种选择。第一是手动在 MyBatis 的 XML 配 置文件中使用<mappers>部分来指定类路径。第二是使用工厂 bean 的 mapperLocations 属 性。 
		mapperLocations 属性使用一个资源位置的 list。 这个属性可以用来指定 MyBatis 的 XML 映射器文件的位置。 它的值可以包含 Ant 样式来加载一个目录中所有文件, 或者从基路径下 递归搜索所有路径。
		
		
		
	注 意 , 如 果 你 想 使 用 CMT , 而 不 想 使 用 Spring 的 事 务 管 理 , 你 就 必 须 配 置 SqlSessionFactoryBean 来使用基本的 MyBatis 的 ManagedTransactionFactory 而不是其 它任意的 Spring 事务管理器: 
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	  	<property name="dataSource" ref="dataSource" />
	  	<property name="transactionFactory">
	    	<bean class="org.apache.ibatis.transaction.managed.ManagedTransactionFactory" />
	  	</property>  
	</bean>
	
	
	
	SqlSessionTemplate
	SqlSessionTemplate 是 MyBatis-Spring 的核心。 这个类负责管理 MyBatis 的 SqlSession, 调用 MyBatis 的 SQL 方法, 翻译异常。 SqlSessionTemplate 是线程安全的, 可以被多个 DAO 所共享使用。 
	当调用 SQL 方法时, 包含从映射器 getMapper()方法返回的方法, SqlSessionTemplate 将会保证使用的 SqlSession 是和当前 Spring 的事务相关的。此外,它管理 session 的生命 周期,包含必要的关闭,提交或回滚操作。 
	SqlSessionTemplate 实现了 SqlSession 接口,这就是说,在代码中无需对 MyBatis 的 SqlSession 进行替换。 SqlSessionTemplate 通常是被用来替代默认的 MyBatis 实现的 DefaultSqlSession , 
	因为模板可以参与到 Spring 的事务中并且被多个注入的映射器类所使 用时也是线程安全的。相同应用程序中两个类之间的转换可能会引起数据一致性的问题。 

	SqlSessionTemplate 有一个使用 ExecutorType 作为参数的构造方法。这允许你用来 创建对象,比如,一个批量 SqlSession,但是使用了下列 Spring 配置的 XML 文件: 
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	 	<constructor-arg index="0" ref="sqlSessionFactory" />
	  	<constructor-arg index="1" value="BATCH" />
	</bean>
	现在你所有的语句可以批量操作了,下面的语句就可以在 DAO 中使用了。 
	public void insertUsers(User[] users) {
		for (User user : users) {
	    	sqlSession.insert("org.mybatis.spring.sample.mapper.UserMapper.insertUser", user);
	   	}
	}
	注意,如果所需的执行方法和默认的 SqlSessionFactory 设置不同,这种配置风格才 能使用。 
	对这种形式需要说明的是当这个方法被调用时,不能有一个存在使用不同 ExecutorType 运行的事务。
	也要保证在不同的事务中,使用不同执行器来调用 SqlSessionTemplate 时, (比如 PROPAGATION_REQUIRES_NEW)或完全在一个事务外面。 

 */
