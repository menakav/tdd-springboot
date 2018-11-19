package com.work.hell.service;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.work.hell.domian.User;
import com.work.hell.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;

	private UserService userService;

	@Before
	public void setup() {
		userService = new UserService(userRepository);
	}

	@Test
	public void getUser_ShouldReturnUserInfo() {
		
		when(userRepository.getOne(1L)).thenReturn(new User("user1", "admin"));
		
		User user = userService.getUserDetails(1);
		Assertions.assertThat(user.getName()).isEqualTo("user1");
		Assertions.assertThat(user.getType()).isEqualTo("admin");
	}

}
