package com.demo.mavendemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.csrf().disable();
	// // 省略其他代码；
	// }

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

	/*
	 * @Bean public FilterRegistrationBean corsFilter() { CorsConfiguration
	 * corsConfig = new CorsConfiguration(); corsConfig.setAllowCredentials(true);
	 * corsConfig.addAllowedOrigin("*"); corsConfig.addAllowedHeader("*");
	 * corsConfig.addAllowedMethod("OPTIONS"); corsConfig.addAllowedMethod("HEAD");
	 * corsConfig.addAllowedMethod("GET"); corsConfig.addAllowedMethod("PUT");
	 * corsConfig.addAllowedMethod("POST"); corsConfig.addAllowedMethod("DELETE");
	 * corsConfig.addAllowedMethod("PATCH"); UrlBasedCorsConfigurationSource
	 * corsConfigSource = new UrlBasedCorsConfigurationSource();
	 * corsConfigSource.registerCorsConfiguration("*", corsConfig); CorsFilter
	 * corsFilter = new CorsFilter(corsConfigSource); FilterRegistrationBean bean =
	 * new FilterRegistrationBean(corsFilter);
	 * bean.setOrder(Ordered.HIGHEST_PRECEDENCE); return bean; }
	 */

	// @Override
	// public void addCorsMappings(final CorsRegistry registry) {
	// registry.addMapping("/api/**")
	// .allowedOrigins("*")
	// .allowedMethods("*")
	// .exposedHeaders("access-control-allow-headers",
	// "access-control-allow-methods",
	// "access-control-allow-origin", "Date", "X-Total-Page");
	// }

	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/api/**")
	// .allowedOrigins("*")
	// .allowedMethods("*")
	// .allowedHeaders("*")
	// .allowCredentials(true);
	//
	// WebMvcConfigurer.super.addCorsMappings(registry);
	// }

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*");

	} // addCorsMappings()

	// @Bean
	// public CorsProcessor corsProcessor() {
	// return new DefaultCorsProcessor();
	// }
	//
	// @Bean
	// public CorsConfiguration corsConfig() {
	// final CorsConfiguration corsConfig = new CorsConfiguration();
	// corsConfig.setAllowCredentials(true);
	// corsConfig.addAllowedOrigin("*");
	// corsConfig.addAllowedHeader("*");
	// corsConfig.addAllowedMethod("GET");
	// corsConfig.addAllowedMethod("POST");
	// corsConfig.addAllowedMethod("PUT");
	// corsConfig.addAllowedMethod("PATCH");
	// corsConfig.addAllowedMethod("DELETE");
	// corsConfig.addAllowedMethod("HEAD");
	// corsConfig.addAllowedMethod("OPTIONS");
	// corsConfig.addAllowedMethod("TRACE");
	// return corsConfig;
	// }

}
