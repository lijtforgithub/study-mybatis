/**
 * @author LiJingTang
 * @version 2015年9月26日 下午12:33:42
 */
package com.ljt.study.mybatis;

/**
  	MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。
  	MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。
  	MyBatis 可以对配置和原生Map使用简单的 XML 或注解，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。
  	
  	命名解析：为了减少输入量，MyBatis 对所有的命名配置元素（包括语句，结果映射，缓存等）使用了如下的命名解析规则。
	完全限定名（比如“com.mypackage.MyMapper.selectAllThings”）将被直接查找并且找到即用。
	短名称（比如“selectAllThings”）如果全局唯一也可以作为一个单独的引用。如果不唯一，有两个或两个以上的相同名称（比如“com.foo.selectAllThings ”和“com.bar.selectAllThings”），那么使用时就会收到错误报告说短名称是不唯一的，这种情况下就必须使用完全限定名。
	
	对象生命周期和依赖注入框架
	依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中，因此可以直接忽略它们的生命周期。
	如果对如何通过依赖注入框架来使用 MyBatis 感兴趣可以研究一下 MyBatis-Spring 或 MyBatis-Guice 两个子项目。
	
	SqlSessionFactoryBuilder这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。因此 SqlSessionFactoryBuilder 实例的最佳范围是方法范围（也就是局部方法变量）。
	你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但是最好还是不要让其一直存在以保证所有的 XML 解析资源开放给更重要的事情。
	
	SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。
	因此 SqlSessionFactory 的最佳范围是应用范围。有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式。
	
	SqlSession每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的范围是请求或方法范围。
	绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。也绝不能将 SqlSession 实例的引用放在任何类型的管理范围中，
	比如 Serlvet 架构中的 HttpSession。如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的范围中。
	换句话说，每次收到的 HTTP 请求，就可以打开一个 SqlSession，返回一个响应，就关闭它。这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭。
	
	
	
	映射器实例（Mapper Instances）映射器是创建用来绑定映射语句的接口。映射器接口的实例是从 SqlSession 中获得的。
	因此从技术层面讲，映射器实例的最大范围是和 SqlSession 相同的，因为它们都是从 SqlSession 里被请求的。尽管如此，映射器实例的最佳范围是方法范围。
	也就是说，映射器实例应该在调用它们的方法中被请求，用过之后即可废弃。并不需要显式地关闭映射器实例，
	尽管在整个请求范围（request scope）保持映射器实例也不会有什么问题，但是很快你会发现，像 SqlSession 一样，在这个范围上管理太多的资源的话会难于控制。所以要保持简单，最好把映射器放在方法范围（method scope）内。
  	
  	如果属性在不只一个地方进行了配置，那么 MyBatis 将按照下面的顺序来加载：
  	在 properties 元素体内指定的属性首先被读取。
	然后根据 properties 元素中的 resource 属性读取类路径下属性文件或根据 url 属性指定的路径读取属性文件，并覆盖已读取的同名属性。
	最后读取作为方法参数传递的属性，并覆盖已读取的同名属性。
	因此，通过方法参数传递的属性具有最高优先级，resource/url 属性中指定的配置文件次之，最低优先级的是 properties 属性中指定的属性。
	
	处理枚举类型
	若想映射枚举类型 Enum，则需要从 EnumTypeHandler 或者 EnumOrdinalTypeHandler 中选一个来使用。
	比如说我们想存储取近似值时用到的舍入模式。默认情况下，MyBatis 会利用 EnumTypeHandler 来把 Enum 值转换成对应的名字。
	注意 EnumTypeHandler 在某种意义上来说是比较特别的，其他的处理器只针对某个特定的类，而它不同，它会处理任意继承了 Enum 的类。
	不过，我们可能不想存储名字，相反我们的 DBA 会坚持使用整形值代码。那也一样轻而易举： 在配置文件中把 EnumOrdinalTypeHandler 加到 typeHandlers 中即可， 这样每个 RoundingMode 将通过他们的序数值来映射成对应的整形。 
	
	插件（plugins）
	MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
    Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
    ParameterHandler (getParameterObject, setParameters)
    ResultSetHandler (handleResultSets, handleOutputParameters)
    StatementHandler (prepare, parameterize, batch, update, query)
    	
	每个数据库对应一个 SqlSessionFactory 实例
	为了指定创建哪种环境，只要将它作为可选的参数传递给 SqlSessionFactoryBuilder 即可。可以接受环境配置的两个方法签名是：
	SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment);
	SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment, properties);

	如果忽略了环境参数，那么默认环境将会被加载，如下所示：
	SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader);
	SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, properties);

	 数据源（dataSource） 元素使用标准的 JDBC 数据源接口来配置 JDBC 连接对象的资源。
	许多 MyBatis 的应用程序将会按示例中的例子来配置数据源。然而它并不是必须的。要知道为了方便使用延迟加载，数据源才是必须的。
	有三种内建的数据源类型（也就是 type=”[UNPOOLED|POOLED|JNDI]”）：

	UNPOOLED– 这个数据源的实现只是每次被请求时打开和关闭连接。虽然一点慢，它对在及时可用连接方面没有性能要求的简单应用程序是一个很好的选择。
	 不同的数据库在这方面表现也是不一样的，所以对某些数据库来说使用连接池并不重要，这个配置也是理想的。UNPOOLED 类型的数据源仅仅需要配置以下 5 种属性：
    driver – 这是 JDBC 驱动的 Java 类的完全限定名（并不是JDBC驱动中可能包含的数据源类）。
    url – 这是数据库的 JDBC URL 地址。
    username – 登录数据库的用户名。
    password – 登录数据库的密码。
    defaultTransactionIsolationLevel – 默认的连接事务隔离级别。
	作为可选项，你也可以传递属性给数据库驱动。要这样做，属性的前缀为“driver.”，例如：
    driver.encoding=UTF8
	这将通过DriverManager.getConnection(url,driverProperties)方法传递值为 UTF8 的 encoding 属性给数据库驱动。

	POOLED– 这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。
	 这是一种使得并发 Web 应用快速响应请求的流行处理方式。
	除了上述提到 UNPOOLED 下的属性外，会有更多属性用来配置 POOLED 的数据源：

    poolMaximumActiveConnections – 在任意时间可以存在的活动（也就是正在使用）连接数量，默认值：10
    poolMaximumIdleConnections – 任意时间可能存在的空闲连接数。
    poolMaximumCheckoutTime – 在被强制返回之前，池中连接被检出（checked out）时间，默认值：20000 毫秒（即 20 秒）
    poolTimeToWait – 这是一个底层设置，如果获取连接花费的相当长的时间，它会给连接池打印状态日志并重新尝试获取一个连接（避免在误配置的情况下一直安静的失败），默认值：20000 毫秒（即 20 秒）。
    poolPingQuery – 发送到数据库的侦测查询，用来检验连接是否处在正常工作秩序中并准备接受请求。默认是“NO PING QUERY SET”，这会导致多数数据库驱动失败时带有一个恰当的错误消息。
    poolPingEnabled – 是否启用侦测查询。若开启，也必须使用一个可执行的 SQL 语句设置 poolPingQuery 属性（最好是一个非常快的 SQL），默认值：false。
    poolPingConnectionsNotUsedFor – 配置 poolPingQuery 的使用频度。这可以被设置成匹配具体的数据库连接超时时间，来避免不必要的侦测，默认值：0（即所有连接每一时刻都被侦测 — 当然仅当 poolPingEnabled 为 true 时适用）。

	JNDI– 这个数据源的实现是为了能在如 EJB 或应用服务器这类容器中使用，容器可以集中或在外部配置数据源，然后放置一个 JNDI 上下文的引用。
	这种数据源配置只需要两个属性：

    initial_context – 这个属性用来在 InitialContext 中寻找上下文（即，initialContext.lookup(initial_context)）。这是个可选属性，如果忽略，那么 data_source 属性将会直接从 InitialContext 中寻找。
    data_source – 这是引用数据源实例位置的上下文的路径。提供了 initial_context 配置时会在其返回的上下文中进行查找，没有提供时则直接在 InitialContext 中查找。
	和其他数据源配置类似，可以通过添加前缀“env.”直接把属性传递给初始上下文。比如：
    env.encoding=UTF8
	这就会在初始上下文（InitialContext）实例化时往它的构造方法传递值为 UTF8 的 encoding 属性。

	通过需要实现接口 org.apache.ibatis.datasource.DataSourceFactory ， 也可使用任何第三方数据源，：
	public interface DataSourceFactory {
		void setProperties(Properties props);
	  	DataSource getDataSource();
	}
	
	
	
	字符串替换 
	默认情况下,使用#{}格式的语法会导致 MyBatis 创建预处理语句属性并安全地设置值（比如?）。这样做更安全，更迅速，通常也是首选做法，
	不过有时你只是想直接在 SQL 语句中插入一个不改变的字符串。比如，像 ORDER BY，你可以这样来使用： 
	ORDER BY ${columnName} 这里 MyBatis 不会修改或转义字符串。 
	以这种方式接受从用户输出的内容并提供给语句中不变的字符串是不安全的，会导致潜在的 SQL 注入攻击，因此要么不允许用户输入这些字段，要么自行转义并检验。 

 
 */