package com.revature.main;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.revature.beans.WeightArchive;
import com.revature.services.WeightArchiveService;

@SpringBootTest
@AutoConfigureMockMvc
class WeightArchiveControllerTests {

	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	WeightArchiveService mockService;
	
	@Autowired
	Gson gson;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void getTest() throws Exception {
		WeightArchive wa = new WeightArchive(0, null, 0, null);
		when(mockService.getWeightArchive(0)).thenReturn(wa);
		this.mockMVC.perform(
				get("/weightArchive/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wa)));
	}
	
	@Test
	public void updateTest() throws Exception {
		WeightArchive wa = new WeightArchive(0, null, 0, null);
		when(mockService.updateWeightArchive(wa)).thenReturn(wa);
		this.mockMVC.perform(
				put("/weightArchive/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(wa)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wa)));
	}

	@Test
	public void deleteTest() throws Exception {
		WeightArchive wa = new WeightArchive(0, null, 0, null);
		when(mockService.deleteWeightArchive(wa)).thenReturn(true);
		this.mockMVC.perform(
				delete("/weightArchive/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(wa)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
	}
}
