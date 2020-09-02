package com.revature.services;

import java.util.List;

import com.revature.beans.Exercise;

public interface ExerciseService {
	
	public Exercise addExercise(Exercise e);
	public Exercise getExercise(int id);
	public Exercise findByName(String name);
	public List<Exercise> getAllExercises();
	public List<Exercise> getExercisesByWorkout(int wid);
	public Exercise updateExercise(Exercise change);
	public boolean deleteExercise(Exercise e);
}
