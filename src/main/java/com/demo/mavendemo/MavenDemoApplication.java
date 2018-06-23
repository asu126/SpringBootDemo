package com.demo.mavendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.demo.domain.ConfigBean;

// 实际上在这里调用了这三个注解
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan

//@EnableAutoConfiguration
//借助@Import的支持，收集和注册特定场景相关的bean定义

@SpringBootApplication
@EnableConfigurationProperties({ ConfigBean.class })
public class MavenDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenDemoApplication.class, args);
	}
}
