package com.work.hell;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.hell.domian.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TddSpringbootApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetUserById() {
		ResponseEntity<User> response = restTemplate.getForEntity("/get/user/1", User.class);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getName()).isEqualTo("user1");
		Assertions.assertThat(response.getBody().getType()).isEqualTo("admin");
		
		
	}

}
