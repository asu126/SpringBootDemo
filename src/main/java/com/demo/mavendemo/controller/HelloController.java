package com.demo.mavendemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mavendemo.config.RedisUtils;

@RestController
public class HelloController {
	// @GetMapping("/")
	// public String root() {
	// return "hello world root";
	// }

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private RedisTemplate redisTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR <
	// FATAL，如果设置为WARN，则低于WARN的信息都不会输出。

	@GetMapping("/helloword")
	public String helloworld() {
		// 方法一：直接在controller 中注入
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set("chose 2", "2222");
		logger.trace("日志输出 trace");
		logger.debug("日志输出 debug");
		logger.info("日志输出 info");
		logger.warn("日志输出 warn");
		logger.error("日志输出 error");
		// 方法二：在公共类中注入并封装，controler 中引用
		redisUtils.set("123", " chose 111");
		return "helloworld" + redisUtils.get("123").toString() + operations.get("chose 2");
	}

}
