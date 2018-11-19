package com.work.hell.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.work.hell.domian.User;
import com.work.hell.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserDetails(long id) {
		User userInfo = userRepository.getOne(id);		
		return userInfo;
	}

}
