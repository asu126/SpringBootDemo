# spring boot 学习demo

### 访问路径
  - http://localhost:8080/login (用戶名、密碼：admin，admin)
  - 优雅的入门篇 -- http://localhost:8080/helloword
  - 配置文件解析 -- http://localhost:8080/config
  - 开发Web应用之Thymeleaf篇 -- http://localhost:8080/course,http://localhost:8080/course/t
  - rabbitMQ
    -- http://localhost:8080/rabbit/hello
    -- http://localhost:8080/rabbit/oneToMany
    -- http://localhost:8080/rabbit/manyToMany
  - 数据库一对一，一对多：
    -- http://localhost:8080/user/1/address
    -- http://localhost:8080/user/1/car
  - insert
    -- https://blog.csdn.net/baochanghong/article/details/54286222
    -- 主键 https://blog.csdn.net/qq_20867981/article/details/80641353

### spring bean 作用域(Scope)
  - 单例(Singleton): 默认
  - 原型(Prototype): 每次注入或者从应用上下文检索的时候，都会创建新的实例
  - 会话(Session)
  - 请求(Request)
```
@Bean
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NotePad { ... }
```

### REST API
- REST 方法： GET,PUT,DELETE,POST
- @RequestParam 获得参数
- @RequestBody 替换基于视图的渲染方式
- @RequestBody 将来自客户端的资源表述转换为对象
- ResponseEntity
- 异常处理：404等

### 跨域参考
- [github](https://github.com/fedej/qremergencias/blob/a66eb6ad75e5f40888604db97e5b628ea72fcade/qremergencias-ws/src/main/java/ar/com/utn/proyecto/qremergencias/ws/config/WebConfig.java)

### 远程服务
- RMI, Hessian, Buarlap, HttpInvoker

### Spring 消息
- 消息模型（生产者，消费者，通道）
  - 点对点模型（队列）
  - 发布/订阅模型（主题）(主题消息可以发送给多个主题订阅)
  - JMS 发送消息
    - ActiveMQ
    - JMS 模板
    - 消息驱动的POJO
  - AMQP : 高级消息队列协议(跨平台，跨语言)
    - 参考1：https://www.cnblogs.com/boshen-hzb/p/6841982.html
    - 参考2：https://www.cnblogs.com/ityouknow/p/6120544.html
    - 在生产者，消费者，通道基础上加了Exchange
      - Direct
      - Topic
      - Headers
      - Fanout

### 数据库访问技术总结
  - JDBC
  - ORM(object-relational mapping): 对象关系映射，eg:Hibernate
  - JPA: java 持久化api

doamin: 定义model(实体对象)，dao/Repository定义数据库访问借口，dao.impl/ Jdbc*Repository定义`借口`具体实现。
易于测试(不与数据访问绑定在一起，使用mock实现)；与持久化技术无关。

### spring-boot-starter-actuator
为 spring boot 添加了一些管理端点
 - GET /autoconfig

### bug 记录
- 1.  `org.springframework.web.servlet.resource.ResourceHttpRequestHandler cannot be cast to org.springframework.web.method.HandlerMethod `
解决办法：https://www.cnblogs.com/hubing/p/6179670.html

- 2. 静态资源处理
静态资源的映射路径，优先级顺序为：META-INF/resources > resources > static > public
spring boot 框架，默认静态资源目录是 resources/static/;
项目编译后，static/ 目录下的文件会直接放到根目录下，所以在访问静态资源时， / 对应的即为 static/ 目录

- 3. caused by: org.springframework.amqp.AmqpIllegalStateException: Fatal exception on listener startup
  消息队列不存在，控制台添加消息队列

### 参考资料
- [Consuming a RESTful Web Service with jQuery]htt(ps://spring.io/guides/gs/consuming-rest-jquery/)
- [静态资源和拦截器处理-demo](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)
- [securing-web](https://spring.io/guides/gs/securing-web/)
- [redis 整合1](https://blog.csdn.net/qq_34579060/article/details/79442692)
- [redis 整合2](https://www.cnblogs.com/huzi007/p/7085152.html)
- [SpringBoot使用Mybatis注解进行一对多和多对多查询](https://blog.csdn.net/KingBoyWorld/article/details/78966789)
- [Mybatis 映射](https://blog.csdn.net/owen_william/article/details/51815473)


- http://tengj.top/2017/04/24/springboot0/
  - [优雅的入门篇](http://tengj.top/2017/02/26/springboot1/)
  - [配置文件解析](http://tengj.top/2017/02/28/springboot2/)
  - [启动原理解析](http://tengj.top/2017/03/09/springboot3/)
  - [开发Web应用之Thymeleaf篇](http://tengj.top/2017/03/13/springboot4/)
  - [开发Web应用之JSP篇](http://tengj.top/2017/03/13/springboot5/)
  - [静态资源和拦截器处理](http://tengj.top/2017/03/30/springboot6/)
  - [默认日志logback配置解析](http://tengj.top/2017/04/05/springboot7/)
  - [数据存储篇-SQL关系型数据库之JdbcTemplate的使用](http://tengj.top/2017/04/13/springboot8/)
  - [数据存储篇-SQL关系型数据库之MyBatis的使用](http://tengj.top/2017/04/23/springboot9/)
  - [开发常用的热部署方式汇总](http://tengj.top/2017/06/01/springboot10/)
  - [数据存储篇-Spring Boot整合Mybatis通用Mapper插件](http://tengj.top/2017/12/20/springboot11/)
  - [Spring Boot使用单元测试](http://tengj.top/2017/12/28/springboot12/)
  - [Spring Boot全局异常处理整理](http://tengj.top/2018/05/16/springboot13/)
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation
