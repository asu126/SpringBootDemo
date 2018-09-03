package com.demo.mavendemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//　启用web　安全功能
@EnableWebSecurity
// @EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * 1. configure(WebSecurity) 2. configure(HttpSecurity) 3.
	 * configure(AuthenticationManagerBuilder)
	 */
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http
	// .csrf().disable();
	// }

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
			.logout().permitAll(); // http://localhost:8080/login?logout
		// @formatter:on
	}

	// https://blog.csdn.net/dream_an/article/details/79381459
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// inMemoryAuthentication 从内存中获取
		// @formatter:off
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        //	.withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER")
        //	.and()
        //	.withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER", "ADMIN");
		// @formatter:on

		// java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for
		// the id "null"
		//

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, isActive from user where username = ?")
				.authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' FROM user WHERE username=?");
	}
}
