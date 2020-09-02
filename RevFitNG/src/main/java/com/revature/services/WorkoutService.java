package com.revature.services;

import java.util.List;

import com.revature.beans.Workout;

public interface WorkoutService {

	public Workout addWorkout(Workout w);
	public Workout getWorkout(int id);
	public List<Workout> getAllWorkouts();
	public List<Workout> getWorkoutsByUser(int id);
	public List<Workout> getWorkoutsByIntensity(String intensity);
	public Workout updateWorkout(Workout change);
	public boolean deleteWorkout(Workout w);
}
