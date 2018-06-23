package com.demo.mavendemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String root() {
		return "hello world root";
	}

	@GetMapping("/hello")
	public String helloworld() {
		return "helloworld";
	}

}
