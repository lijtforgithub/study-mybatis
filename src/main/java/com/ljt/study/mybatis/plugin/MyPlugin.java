package com.ljt.study.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * 通过 MyBatis 提供的强大机制，使用插件是非常简单的，只需实现 Interceptor 接口，并指定了想要拦截的方法签名即可
 * 下面的插件将会拦截在 Executor 实例中所有的 update方法调用， 这里的 Executor 是负责执行低层映射语句的内部对象。
 * 
 * @author LiJingTang
 * @version 2015年9月26日 下午7:36:54
 */
@Intercepts({@Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class})})
public class MyPlugin implements Interceptor {
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}
	
}