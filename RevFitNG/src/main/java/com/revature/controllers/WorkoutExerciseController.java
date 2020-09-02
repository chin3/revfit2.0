package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.WorkoutExercise;
import com.revature.services.WorkoutExerciseService;
import com.revature.util.WorkoutExerciseId;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class WorkoutExerciseController {
	@Autowired
	WorkoutExerciseService ws;
	
	@PostMapping(value = "/workoutExercise", consumes = "application/json", produces = "application/json")
	public WorkoutExercise addWorkoutExercise(@RequestBody WorkoutExercise we) {
		return ws.addWorkoutExercise(we);
	}
	
	@GetMapping(value = "/workoutExercise", produces = "application/json")
	public List<WorkoutExercise> getAllWorkoutExercises() {
		return ws.getAllWorkoutExercises();
	}
	
	@GetMapping(value = "/workoutExercise/search", produces = "application/json")
	public WorkoutExercise getWorkoutExercise(@RequestParam(name = "workout_id") int workout_id, @RequestParam(name = "exercise_id") int exercise_id) {
		return ws.getWorkoutExercise(new WorkoutExerciseId(workout_id, exercise_id));
	}
	
	@PutMapping(value = "/workoutExercise/search", produces = "application/json")
	public WorkoutExercise updateWorkout(@RequestParam(name = "workout_id") int workout_id, @RequestParam(name = "exercise_id") int exercise_id, @RequestBody WorkoutExercise change) {
		change.setId(new WorkoutExerciseId(workout_id, exercise_id));
		return ws.updateWorkoutExercise(change);
	}

	@DeleteMapping(value = "/workoutExercise/search")
	public boolean deleteWorkoutExercise(@RequestParam(name = "workout_id") int workout_id, @RequestParam(name = "exercise_id") int exercise_id) {
		return ws.deleteWorkoutExercise(ws.getWorkoutExercise(new WorkoutExerciseId(workout_id, exercise_id)));
	}

}
