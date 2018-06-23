package com.demo.mavendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.ConfigBean;

@RestController
public class ConfigController {

	@Value("${com.demo.name}")
	private String name;
	@Value("${com.demo.want}")
	private String want;

	@RequestMapping("/config")
	public String hexo() {
		return name + ", " + want;
	}

	@Autowired
	ConfigBean configBean;

	@RequestMapping("/config1")
	public String hexo1() {
		return configBean.getName() + configBean.getWant();
	}
}
