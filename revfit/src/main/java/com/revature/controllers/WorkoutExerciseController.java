package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.WorkoutExercise;
import com.revature.services.WorkoutExerciseService;
import com.revature.util.WorkoutExerciseId;

@CrossOrigin(maxAge = 3600, origins = "http://revfitbucket.s3-website.us-east-2.amazonaws.com")
//@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class WorkoutExerciseController {
	@Autowired
	WorkoutExerciseService ws;
	
	@PostMapping(value = "/workoutExercise", consumes = "application/json", produces = "application/json")
	public List<WorkoutExercise> addWorkoutExercise(@RequestBody List<WorkoutExercise> we) {
		return ws.addWorkoutExercise(we);
	}
	
	@GetMapping(value = "/workoutExercise", produces = "application/json")
	public List<WorkoutExercise> getAllWorkoutExercises() {
		return ws.getAllWorkoutExercises();
	}
	
	@GetMapping(value = "/workoutExercise/{id}")
	public List<WorkoutExercise> getAllByWorkout(@PathVariable("id") int wid) {
		return ws.getAllByWorkout(wid);
	}
	
	@PostMapping(value = "/workoutExercise/search", produces = "application/json")
	public WorkoutExercise getWorkoutExercise(@RequestBody WorkoutExerciseId id) {
		return ws.getWorkoutExercise(id);
	}
	
	@PutMapping(value = "/workoutExercise/search", produces = "application/json")
	public WorkoutExercise updateWorkout(@RequestBody WorkoutExercise change) {
		return ws.updateWorkoutExercise(change);
	}

	@DeleteMapping(value = "/workoutExercise/search")
	public boolean deleteWorkoutExercise(@RequestBody WorkoutExercise w) {
		return ws.deleteWorkoutExercise(ws.getWorkoutExercise(w.getId()));
	}

}
