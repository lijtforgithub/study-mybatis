package com.ljt.study.mybatis.factory;

import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * MyBatis 每次创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成。
 * 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认构造方法，要么在参数映射存在的时候通过参数构造方法来实例化。 
 * 如果想覆盖对象工厂的默认行为，则可以通过创建自己的对象工厂来实现。
 * 
 * @author LiJingTang
 * @version 2015年9月26日 下午7:30:00
 */
public class MyObjectFactory extends DefaultObjectFactory {
	
	private static final long serialVersionUID = -8182904472507538870L;

//	@Override
//	public Object create(Class type) {
//		return super.create(type);
//	}
//
//	@Override
//	public Object create(Class type, List<Class> constructorArgTypes, List<Object> constructorArgs) {
//		return super.create(type, constructorArgTypes, constructorArgs);
//	}
	
	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
	
}