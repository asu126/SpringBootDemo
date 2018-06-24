package com.demo.mavendemo.controller;

import com.demo.mavendemo.controller.HelloController;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloControllerTest {

	@Test
	public void testHomePage() throws Exception {
		HelloController controller = new HelloController();
		assertEquals("helloworld", controller.helloworld());
	}

}
