package com.revature.main;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.revature.beans.Workout;
import com.revature.services.WorkoutService;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkoutContollerTest {

	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	WorkoutService mockService;
	
	@Autowired
	Gson gson;
	
	@Test
	public void addTest() throws Exception {
		Workout wa = new Workout(0, null, null, null, null, null);
		when(mockService.addWorkout(wa)).thenReturn(wa);
		this.mockMVC.perform(
				post("/workout").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(wa)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wa)));
	}
	
	@Test
	public void getTest() throws Exception {
		Workout wa = new Workout(0, null, null, null, null, null);
		when(mockService.getWorkout(0)).thenReturn(wa);
		List<Workout> workout = new ArrayList<Workout>();
		workout.add(wa);
		this.mockMVC.perform(
				get("/workout/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json((gson.toJson(workout))));
	}
	
	@Test
	public void getIntensityTest() throws Exception {
		Workout wa = new Workout(0, null, "i", null, null, null);
		List<Workout> workout = new ArrayList<Workout>();
		workout.add(wa);
		when(mockService.getWorkoutsByIntensity("i")).thenReturn(workout);
		this.mockMVC.perform(
				get("/workout/i"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json((gson.toJson(workout))));
	}
	
	@Test
	public void getUserWorkoutsTest() throws Exception {
		User u = new User(0,null, null, null, null, null, null, 0, 0);
		List<Workout> wlist = new ArrayList<Workout>();
		when(mockService.getWorkoutsByUser(0)).thenReturn(wlist);
		this.mockMVC.perform(
				post("/workout/search").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(u)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wlist)));
	}
	
	@Test
	public void getWorkoutTimesTest() throws Exception {
		when(mockService.getWorkoutTime(0)).thenReturn(0.0);
		this.mockMVC.perform(
				get("/workout/0/time"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("0.0"));
	}
	
	@Test
	public void getAllWorkoutsTest() throws Exception {
		List<Workout> wlist = new ArrayList<Workout>();
		when(mockService.getAllWorkouts()).thenReturn(wlist);
		this.mockMVC.perform(
				get("/workout"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wlist)));
	}
	
	@Test
	public void updateTest() throws Exception {
		Workout wa = new Workout(0, null, null, null, null, null);
		when(mockService.updateWorkout(wa)).thenReturn(wa);
		this.mockMVC.perform(
				put("/workout/0").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(wa)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wa)));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Workout wa = new Workout(0, null, null, null, null, null);
		when(mockService.deleteWorkout(mockService.getWorkout(0))).thenReturn(true);
		this.mockMVC.perform(
				delete("/workout/0"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
	}
	
}
