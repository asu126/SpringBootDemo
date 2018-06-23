package com.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.demo")
public class ConfigBean {
	private String name;
	private String want;

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWant() {
		return want;
	}

	public void setWant(String w) {
		this.want = w;
	}
}