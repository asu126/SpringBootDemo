package com.demo.mavendemo.controller;

import com.demo.mavendemo.controller.ThymeleafController;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;

public class ThymeleafControllerTest {
	@Test
	public void testHomePageMoca() throws Exception {
		ThymeleafController controller = new ThymeleafController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/learn")).andExpect(view().name("/learn/index"));
	}
}
