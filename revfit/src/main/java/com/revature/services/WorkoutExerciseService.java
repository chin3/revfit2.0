package com.revature.services;

import java.util.List;

import com.revature.beans.WorkoutExercise;
import com.revature.util.WorkoutExerciseId;

public interface WorkoutExerciseService {
	public WorkoutExercise addWorkoutExercise(WorkoutExercise e);
	public WorkoutExercise getWorkoutExercise(WorkoutExerciseId id);
	public List<WorkoutExercise> getAllWorkoutExercises();
	public WorkoutExercise updateWorkoutExercise(WorkoutExercise change);
	public boolean deleteWorkoutExercise(WorkoutExercise e);
}
