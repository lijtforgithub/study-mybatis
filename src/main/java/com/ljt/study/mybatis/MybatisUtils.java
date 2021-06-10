package com.ljt.study.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.ljt.study.mybatis.factory.DataSouceFactory;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午12:39:20
 */
public class MybatisUtils {
	
	private MybatisUtils() {}
	
	public static SqlSessionFactory loadSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream input = null;
		
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
//			.build(inputStream, properties);
		closeInputStream(input);
		
		return sqlSessionFactory ;
	}

	private static void closeInputStream(InputStream input) {
		if (null == input) {
			return;
		}
		
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		DataSource dataSource = DataSouceFactory.newDataSourceInstace();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
//		configuration.addMapper(BlogMapper.class);
		
		return new SqlSessionFactoryBuilder().build(configuration);
	}

}
