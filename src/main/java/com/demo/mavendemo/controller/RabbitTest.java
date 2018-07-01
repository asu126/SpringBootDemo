package com.demo.mavendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mavendemo.rabbit.HelloSender1;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

	@Autowired
	private HelloSender1 helloSender1;
	@Autowired
	private HelloSender1 helloSender2;

	// @PostMapping("/hello")
	@RequestMapping("hello")
	public String hello() {
		helloSender1.send();
		return "rabbit hello";
	}

	/**
	 * 单生产者-多消费者
	 */
	// @PostMapping("/oneToMany")
	@RequestMapping("oneToMany")
	public void oneToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg:" + i);
		}
	}

	/**
	 * 多生产者-多消费者
	 */

	// @PostMapping("/manyToMany")
	@RequestMapping("manyToMany")
	public void manyToMany() {
		for (int i = 0; i < 10; i++) {
			helloSender1.send("hellomsg:" + i);
			helloSender2.send("hellomsg:" + i);
		}

	}
}
