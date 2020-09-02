package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Exercise;
import com.revature.beans.WorkoutExercise;
import com.revature.repositories.ExerciseRepository;
import com.revature.repositories.WorkoutExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	ExerciseRepository er;

	@Autowired
	WorkoutExerciseRepository wer;
	
	@Override
	public Exercise addExercise(Exercise e) {
		return er.save(e);
	}

	@Override
	public Exercise getExercise(int id) {
		return er.findById(id).get();
	}

	@Override
	public Exercise findByName(String name) {
		return er.findByName(name);
	}

	@Override
	public List<Exercise> getAllExercises() {
		return (List<Exercise>) er.findAll();
	}

	public List<Exercise> getExercisesByWorkout(int wid) {
		List<WorkoutExercise> wes = (List<WorkoutExercise>) wer.findAll();
		List<Exercise> exercises = new ArrayList<Exercise>();
		
		for(WorkoutExercise we : wes) {
			if(we.getId().getWorkoutId() == wid) {
				exercises.add(er.findById(we.getId().getExerciseId()).get());
			}
		}
		
		return exercises;
	}
	
	@Override
	public Exercise updateExercise(Exercise change) {
		return er.save(change);
	}

	@Override
	public boolean deleteExercise(Exercise e) {
		try {
			er.delete(e);
			return true;
		} catch (IllegalArgumentException er) {
			er.printStackTrace();
			return false;
		}
	}
}
