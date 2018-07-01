package com.demo.mavendemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController 会为该控制器所有处理方法应用消息转换功能
@RestController
@RequestMapping("/api")
public class RestAPI {

	// @RequestMapping("greeting")
	@RequestMapping(value = "greeting", method = RequestMethod.GET, produces = "application/json")
	public Greeting greeting(@RequestParam(value = "page", defaultValue = "1") int page) {
		System.out.println("page is:" + page);
		return new Greeting(666, "rest api greeting");
	}

	class Greeting {
		private int id;
		private String content;

		public Greeting(int id, String content) {
			this.id = id;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

}
