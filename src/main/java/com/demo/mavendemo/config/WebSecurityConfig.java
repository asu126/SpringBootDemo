package com.demo.mavendemo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends
WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		.csrf().disable()
		    .authorizeRequests().antMatchers("/", "/api/**", "/home", "learn/queryLeanList").permitAll() // 无条件允许访问
		    .anyRequest().authenticated() // 允许认证过的用户
			.and().headers().frameOptions().disable()
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
