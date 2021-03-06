package com.demo.mavendemo;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.mavendemo.domain.ConfigBean;
//import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

// 实际上在这里调用了这三个注解
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan

//@EnableAutoConfiguration
//借助@Import的支持，收集和注册特定场景相关的bean定义

@SpringBootApplication
@EnableConfigurationProperties({ ConfigBean.class })
@EnableGlobalMethodSecurity(securedEnabled = true)

// 重要: 实现mapper的自动注入
@MapperScan(basePackages = "com.demo.mavendemo.mapper")
public class MavenDemoApplication extends SpringBootServletInitializer {

	/**
	 * 配置静态访问资源
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MavenDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MavenDemoApplication.class, args);
	}

	/**
	 * 文件上传配置
	 *
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		// 可以对上传文件的大小、缓存目录等限制
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("10240KB"); // KB, MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}

	@Autowired
	private Environment env;

	// destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));// 用户名
		dataSource.setPassword(env.getProperty("spring.datasource.password"));// 密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setInitialSize(2);// 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
		dataSource.setMaxActive(20);// 最大连接池数量
		dataSource.setMinIdle(0);// 最小连接池数量
		dataSource.setMaxWait(60000);// 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
		dataSource.setValidationQuery("SELECT 1");// 用来检测连接是否有效的sql，要求是一个查询语句，常用select
													// 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
		dataSource.setTestOnBorrow(false);// 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
		dataSource.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
		dataSource.setPoolPreparedStatements(false);// 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
		return dataSource;
	}
}
