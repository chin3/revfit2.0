package com.revature.main;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.revature.beans.Role;
import com.revature.services.RoleService;

@SpringBootTest
@AutoConfigureMockMvc
public class RoleControllerTests {
	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	RoleService mockService;
	
	@Autowired
	Gson gson;
	
	Role r = new Role(0,"name","description");
	
	@Test
	public void getRole() throws Exception{
		when(mockService.getRole(0)).thenReturn(r);
		this.mockMVC.perform(
				get("/Role/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(r)));
	
	}
	@Test
	public void addRole() throws Exception{
		when(mockService.addRole(r)).thenReturn(r);
		this.mockMVC.perform(
				post("/Role").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(r)) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(r)));
	
	}
	@Test
	public void allRole() throws Exception {
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(r);
		when(mockService.getAllRoles()).thenReturn(roles);
		this.mockMVC.perform(
				get("/Role"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(roles)));
		
		
	}
	
	@Test
	public void updateRole() throws Exception{
		when(mockService.updateRole(r)).thenReturn(r);
		this.mockMVC.perform(
				put("/Role/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(r)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(r)));
	}
	@Test
	public void deleteTest() throws Exception {
		when(mockService.deleteRole(any())).thenReturn(true);
		this.mockMVC.perform(
				delete("/Role/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(r)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
	}
	
	
	}
	
	
		
	