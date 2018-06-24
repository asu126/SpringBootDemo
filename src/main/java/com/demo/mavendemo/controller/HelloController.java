package com.demo.mavendemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//	@GetMapping("/")
//	public String root() {
//		return "hello world root";
//	}

	@GetMapping("/helloword")
	public String helloworld() {
		return "helloworld";
	}

}
