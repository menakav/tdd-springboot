package com.work.hell.repository;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.hell.domian.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestEntityManager entityManager;


	@Test
	public void testGetOne_ShouldOneUser() {
		User Expecteduser = entityManager.persistAndFlush(new User("user1", "admin"));
		
		User Actualuser = userRepository.getOne(1L);
		Assertions.assertThat(Actualuser.getName()).isEqualTo(Expecteduser.getName());
		Assertions.assertThat(Actualuser.getType()).isEqualTo(Expecteduser.getType());
	}

}
