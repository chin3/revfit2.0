package com.revature.main;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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
import com.revature.beans.Permission;
import com.revature.beans.Role;
import com.revature.services.PermissionService;

@SpringBootTest
@AutoConfigureMockMvc
public class PermissionControllerTest {
	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	PermissionService mockService;
	
	@Autowired
	Gson gson;
	
	Permission p = new Permission(0,"name", "description");
	
	@Test
	public void getPermission() throws Exception {
		when(mockService.getPermission(0)).thenReturn(p);
		this.mockMVC.perform(
				get("/Permission/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(p)));
		
	}
	@Test
	public void addPermission() throws Exception{
		when(mockService.addPermission(p)).thenReturn(p);
		this.mockMVC.perform(
				post("/Permission").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(p)) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(p)));
	
	}
	@Test
	public void allPermission() throws Exception {
		ArrayList<Permission> permissions = new ArrayList<Permission>();
		permissions.add(p);
		when(mockService.getAllPermissions()).thenReturn(permissions);
		this.mockMVC.perform(
				get("/Permission"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(permissions)));
		
		
	}
	@Test
	public void updatePermission() throws Exception{
		when(mockService.updatePermission(p)).thenReturn(p);
		this.mockMVC.perform(
				put("/Permission/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(p)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(p)));
	}
	
	@Test
	public void deleteTest() throws Exception {
		when(mockService.deletePermission(any())).thenReturn(true);
		this.mockMVC.perform(
				delete("/Permission/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(p)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
	}

}
