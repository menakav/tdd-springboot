package com.work.hell.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.work.hell.domian.User;
import com.work.hell.handlers.UserNotFoudException;
import com.work.hell.service.UserService;

@RestController
public class UserController {
	
	UserService userService;	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/get/user/{id}")
	public User getUser(@PathVariable long id) {
		User user = userService.getUserDetails(id);
		return user;	
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void userNotFoundException(UserNotFoudException ex) {
	}

}
