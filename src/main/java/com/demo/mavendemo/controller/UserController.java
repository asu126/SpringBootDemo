package com.demo.mavendemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mavendemo.domain.User;
import com.demo.mavendemo.mapper.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	UserRepository userRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@PathVariable Long id) {

		User user = userRepository.findUserById(id);
		System.out.println(user.getName());
		System.out.println(user.getAddressId());
		System.out.println(user);
		return user;

	}

	@GetMapping(value = "/{id}/address")
	public String findUserWithAddress(@PathVariable Long id) {
		User userWithAddress = userRepository.findUserWithAddress(id);
		return userWithAddress.getAddress().toString();
	}

	@GetMapping(value = "/{id}/car")
	public String findUserWithCar(@PathVariable Long id) {
		User user = userRepository.getUserWithCar(id);
		return user.getCars().toString();
	}

	// 异常处理
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler() {
		return "eeeee";
	}
}
