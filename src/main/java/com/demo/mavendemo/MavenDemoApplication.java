package com.demo.mavendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.demo.domain.ConfigBean;
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

	// @Order(Ordered.HIGHEST_PRECEDENCE)
	// @Configuration
	// protected static class AuthenticationSecurity {
	//
	// @SuppressWarnings("deprecation")
	// @Bean
	// public InMemoryUserDetailsManager inMemoryUserDetailsManager() throws
	// Exception {
	// return new InMemoryUserDetailsManager(
	// User.withDefaultPasswordEncoder().username("admin").password("admin")
	// .roles("ADMIN", "USER", "ACTUATOR").build(),
	// User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
	// }
	//
	// }

	@Configuration
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.authorizeRequests().antMatchers("/", "/home").permitAll() // 无条件允许访问
				.anyRequest().authenticated() // 允许认证过的用户
				.and()
				.formLogin().loginPage("/login").permitAll() // 认证用户
				.and()
				.httpBasic()
				.and()
				.rememberMe().tokenValiditySeconds(60*60*24)
				.and()
				.logout().permitAll();
			// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// inMemoryAuthentication 从内存中获取
			// @formatter:off
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
				.withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER")
				.and()
				.withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER", "ADMIN");
			// @formatter:on
		}

	}

	// @Configuration
	// @Order(1)
	// protected static class ActuatorSecurity extends WebSecurityConfigurerAdapter
	// {
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// // @formatter:off
	// http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests().anyRequest().authenticated().and()
	// .httpBasic();
	// // @formatter:on
	// }
	//
	// }

}
