package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.services.WorkoutService;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class WorkoutController {

	@Autowired
	WorkoutService ws;

	@PostMapping(value = "/workout", consumes = "application/json", produces = "application/json")
	public Workout addWorkout(@RequestBody Workout w) {
		return ws.addWorkout(w);
	}

	@GetMapping(value = "/workout/{idOrIntensity}", produces = "application/json")
	public List<Workout> getWorkout(@PathVariable(name = "idOrIntensity", required = false) String idOrIntensity) {
		if (idOrIntensity == null) {
			return null;
		}
		try {
			int id = Integer.parseInt(idOrIntensity);
			return new ArrayList<Workout>(Arrays.asList(ws.getWorkout(id)));
		} catch (NumberFormatException e) {
			return ws.getWorkoutsByIntensity(idOrIntensity);
		}

	}

	@PostMapping(value = "/workout/search")
	public List<Workout> getWorkoutsByUser(@RequestBody User u) {
		return ws.getWorkoutsByUser(u.getId());
	}

	@GetMapping(value = "/workout", produces = "application/json")
	public List<Workout> getAllWorkouts() {
		return ws.getAllWorkouts();
	}

	@PutMapping(value = "/workout/{id}", produces = "application/json")
	public Workout updateWorkout(@PathVariable("id") int id, @RequestBody Workout change) {
		change.setId(id);
		return ws.updateWorkout(change);
	}

	@DeleteMapping(value = "/workout/{id}")
	public boolean deleteWorkout(@PathVariable("id") int id) {
		return ws.deleteWorkout(ws.getWorkout(id));
	}

}
