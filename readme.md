# spring boot 学习demo

### 访问路径
  - 优雅的入门篇 -- http://localhost:8080/hello
  - 配置文件解析 -- http://localhost:8080/config
  - 开发Web应用之Thymeleaf篇 -- http://localhost:8080/learn,http://localhost:8080/learn/t


### bug 记录
- 1.  `org.springframework.web.servlet.resource.ResourceHttpRequestHandler cannot be cast to org.springframework.web.method.HandlerMethod `
解决办法：https://www.cnblogs.com/hubing/p/6179670.html

- 2. 静态资源处理
spring boot 框架，默认静态资源目录是 resources/static/;
项目编译后，static/ 目录下的文件会直接放到根目录下，所以在访问静态资源时， / 对应的即为 static/ 目录

### 参考资料
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
