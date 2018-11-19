package com.work.hell.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.work.hell.domian.User;
import com.work.hell.handlers.UserNotFoudException;
import com.work.hell.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userServiceMock;

	@Test
	public void getUser_ShouldReturnUser() throws Exception
	{
		
		when(userServiceMock.getUserDetails(Mockito.anyLong())).thenReturn(new User("user1" , "admin"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/get/user/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("name").value("user1"))
		.andExpect(jsonPath("type").value("admin"));
	}
	
	@Test
	public void getUser_ThrowUserNotFounDException() throws Exception
	{
		when(userServiceMock.getUserDetails(Mockito.anyLong())).thenThrow(new UserNotFoudException());
	}

}
