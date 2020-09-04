package com.revature.main;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.revature.beans.Exercise;
import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.beans.WorkoutExercise;
import com.revature.services.WorkoutExerciseService;
import com.revature.util.WorkoutExerciseId;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkoutExerciseControllerTest {

	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	WorkoutExerciseService mockService;
	
	@Autowired
	Gson gson;
	
	@Test
	public void addTest() throws Exception {
		List<WorkoutExercise> we = new ArrayList<WorkoutExercise>();
		when(mockService.addWorkoutExercise(we)).thenReturn(we);
		this.mockMVC.perform(
				post("/workoutExercise").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(we)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(we)));
	}
	
	@Test
	public void getAllWorkoutExercisesTest() throws Exception {
		List<WorkoutExercise> wlist = new ArrayList<WorkoutExercise>();
		when(mockService.getAllWorkoutExercises()).thenReturn(wlist);
		this.mockMVC.perform(
				get("/workoutExercise"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(wlist)));
	}
	
	@Test
	public void getAllWidTest() throws Exception {
		List<WorkoutExercise> wlist = new ArrayList<WorkoutExercise>();
		when(mockService.getAllByWorkout(0)).thenReturn(wlist);
		this.mockMVC.perform(
				get("/workoutExercise/0"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json((gson.toJson(wlist))));
	}
	
	@Test
	public void getWorkoutExerciseIdTest() throws Exception {
		WorkoutExerciseId id = new WorkoutExerciseId(0, 0);
		Workout w = new Workout(0, null, null, null, null, null);
		Exercise e = new Exercise(0, null, null, 0);
		WorkoutExercise we = new WorkoutExercise(null, null, null, null, 0);
		when(mockService.getWorkoutExercise(id)).thenReturn(we);
		this.mockMVC.perform(
				post("/workoutExercise/search").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(id)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(we)));
	}
	
	@Test
	public void updateWorkoutExerciseTest() throws Exception {
		WorkoutExercise we = new WorkoutExercise(null, null, null, null, null);
		when(mockService.updateWorkoutExercise(any())).thenReturn(we);
		this.mockMVC.perform(
				put("/workoutExercise/search").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(we)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(we)));
	}
	
	@Test
	public void deleteWorkoutExerciseTest() throws Exception {
		WorkoutExercise we = new WorkoutExercise(null, null, null, null, null);
		when(mockService.deleteWorkoutExercise(any())).thenReturn(true);
		this.mockMVC.perform(
				delete("/workoutExercise/search").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(we)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("true"));
	}
}
