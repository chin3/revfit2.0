package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Exercise;
import com.revature.services.ExerciseService;

@RestController
public class ExerciseController {
	@Autowired
	ExerciseService es;

	@RequestMapping(value = "/exercise", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Exercise addExercise(@RequestBody Exercise e) {
		return es.addExercise(e);
	}

	@GetMapping(value = "/exercise/{id}", produces = "application/json")
	public Exercise getExercise(@PathVariable("id") String idOrName) {
		try {
			return es.getExercise(Integer.parseInt(idOrName));			
		} catch(NumberFormatException e) {
			return es.findByName(idOrName);
		}
	}
	
	@GetMapping(value = "/exercise")
	public List<Exercise> getAllExercises() {
		return es.getAllExercises();
	}
	
	@GetMapping(value = "/exercise/search/{id}")
	public List<Exercise> getExercisesByWorkout(@PathVariable("id") int wid) {
		return es.getExercisesByWorkout(wid);
	}

	@PutMapping(value = "/exercise/{id}", consumes = "application/json", produces = "application/json")
	public Exercise updateExercise(@PathVariable("id") int id, @RequestBody Exercise change) {
		change.setId(id);
		return es.updateExercise(change);
	}

	@DeleteMapping(value = "/exercise/{id}")
	public boolean deleteExercise(@PathVariable("id") int id) {
		return es.deleteExercise(es.getExercise(id));
	}
	

}
