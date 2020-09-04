package com.revature.main;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.UsernamePassword;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTests {
	
	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	UserService mockService;
	
	@Autowired
	Gson gson;
	
	@Test
	public void getUser() throws Exception {
		
		User us = new User();
		
		when(mockService.getUser(0)).thenReturn(us);
		this.mockMVC.perform(
				get("/user/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(us)));
	}
	
	@Test
	public void updateUser() throws Exception {
		User us = new User();
		
		when(mockService.updateUser(us)).thenReturn(us);
		this.mockMVC.perform(
				put("/user/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(us)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(us)));
	}
	
	@Test
	public void addUser() throws Exception {
		User us = new User();
		
		when(mockService.addUser(us)).thenReturn(us);
		this.mockMVC.perform(
			post("/user").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(us)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json(gson.toJson(us)));
	}
	
	@Test
	public void allUsers() throws Exception {
		List<User> allUsers = new ArrayList<User>();
		
		when(mockService.getAllUsers()).thenReturn(allUsers);
		this.mockMVC.perform(
				get("/user").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(allUsers)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(allUsers)));
		
	}
	
	@Test
	public void deleteUser() throws Exception{
		User us = new User();
			us.setId(0);
		
		when(mockService.getUser(0)).thenReturn(us);
		when(mockService.deleteUser(us)).thenReturn(true);
		this.mockMVC.perform(
			delete("/user/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(us)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("true"));
	}
	
	@Test
	public void loginUser() throws Exception {
		
		String username = "username";
		String password = "password";
		UsernamePassword up = new UsernamePassword(username,password);
		User us = new User(0, null, username, password, password, password, password, 0, 0);
		
		when(mockService.login(username,password)).thenReturn(us);
		this.mockMVC.perform(
			post("/user/login").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(up)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json(gson.toJson(up)));
	}
	
	
}
