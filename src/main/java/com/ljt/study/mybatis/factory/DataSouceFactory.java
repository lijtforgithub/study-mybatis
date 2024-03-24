package com.ljt.study.mybatis.factory;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

/**
 * @author LiJingTang
 * @version 2015年9月26日 下午12:49:33
 */
public class DataSouceFactory {
	
	private static DataSource dataSource = getDataSource();
	
	private DataSouceFactory() {}
	
	public static DataSource newDataSourceInstace () {
		return dataSource;
	}
	
	private static DataSource getDataSource() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		String driverClassName = resourceBundle.getString("jdbc.driverClassName").trim();
		String url = resourceBundle.getString("jdbc.url").trim();
		String username = resourceBundle.getString("jdbc.username").trim();
		String password = resourceBundle.getString("jdbc.password").trim();
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverClassName);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setInitialSize(50);
		basicDataSource.setMaxIdle(100);
		basicDataSource.setMaxIdle(30);
		basicDataSource.setMaxWaitMillis(10000);
		
		return basicDataSource;
	}

}
