/**
 * @author LiJingTang
 * @version 2015年9月29日 下午8:38:22
 */
package com.ljt.study.page;

/**
	在Mybatis配置xml中配置拦截器插件:
	
	<plugins>
	    <!-- com.github.pagehelper为PageHelper类所在包名 -->
	    <plugin interceptor="com.github.pagehelper.PageHelper">
	        <!-- 4.0.0以后版本可以不设置该参数 -->
	        <property name="dialect" value="mysql"/>
	        <!-- 该参数默认为false -->
	        <!-- 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用 -->
	        <!-- 和startPage中的pageNum效果一样-->
	        <property name="offsetAsPageNum" value="true"/>
	        <!-- 该参数默认为false -->
	        <!-- 设置为true时，使用RowBounds分页会进行count查询 -->
	        <property name="rowBoundsWithCount" value="true"/>
	        <!-- 设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果 -->
	        <!-- （相当于没有执行分页查询，但是返回结果仍然是Page类型）-->
	        <property name="pageSizeZero" value="true"/>
	        <!-- 3.3.0版本可用 - 分页参数合理化，默认false禁用 -->
	        <!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
	        <!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
	        <property name="reasonable" value="false"/>
	        <!-- 3.5.0版本可用 - 为了支持startPage(Object params)方法 -->
	        <!-- 增加了一个`params`参数来配置参数映射，用于从Map或ServletRequest中取值 -->
	        <!-- 可以配置pageNum,pageSize,count,pageSizeZero,reasonable,不配置映射的用默认值 -->
	        <!-- 不理解该含义的前提下，不要随便复制该配置 -->
	        <property name="params" value="pageNum=start;pageSize=limit;"/>
	    </plugin>
	</plugins>
	
	
	1.增加dialect属性，使用时可以指定该属性（不指定的情况下，分页插件会自动判断），可选值为oracle,mysql,mariadb,sqlite,hsqldb,postgresql,db2,sqlserver,informix。
	2.增加offsetAsPageNum属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。
		当该参数设置为true时，使用RowBounds分页时，会将offset参数当成pageNum使用，可以用页码和页面大小两个参数进行分页。
	3.增加rowBoundsWithCount属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。
		当该参数设置为true时，使用RowBounds分页会进行count查询。
	4.增加pageSizeZero属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。
		当该参数设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是Page类型）。
	5.增加reasonable属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。
	6.为了支持startPage(Object params)方法，增加了一个params参数来配置参数映射，用于从Map或ServletRequest中取值，
		可以配置pageNum,pageSize,count,pageSizeZero,reasonable,不配置映射的用默认值。

	重要提示：
	当offsetAsPageNum=false的时候，由于PageNum问题，RowBounds查询的时候reasonable会强制为false。使用PageHelper.startPage方法不受影响。
	另外使用RowBounds在这种情况下返回的Page对象由于没有正确的pageNum属性，所以也不能使用PageInfo处理。
*/