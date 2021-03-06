package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Exercise;
import com.revature.beans.Workout;
import com.revature.beans.WorkoutExercise;
import com.revature.repositories.WorkoutExerciseRepository;
import com.revature.repositories.WorkoutRepository;

@Service
public class WorkoutServiceImpl implements WorkoutService{

	@Autowired
	WorkoutRepository wr;

	@Autowired
	WorkoutExerciseRepository war;
	
	@Override
	public Workout addWorkout(Workout w) {		
		return wr.save(w);
	}

	@Override
	public Workout getWorkout(int id) {
		return wr.findById(id).get();
	}

	@Override
	public List<Workout> getAllWorkouts() {
		return (List<Workout>) wr.findAll();
	}

	@Override
	public List<Workout> getWorkoutsByUser(int id) {
		List<Workout> workouts = (List<Workout>) wr.findAll();
		List<Workout> userWorkouts = new ArrayList<Workout>();
		for(Workout w : workouts) {
			if(w.getUser().getId() == id) {
				userWorkouts.add(w);
			}
		}
		return userWorkouts;
	}
	
	@Override
	public List<Workout> getWorkoutsByIntensity(String intensity) {
		List<Workout> workouts = (List<Workout>) wr.findAll();
		List<Workout> works = new ArrayList<Workout>();
		for(Workout w : workouts) {
			if(w.getIntensity().equalsIgnoreCase(intensity)) {
				works.add(w);
			}
		}
		return works;
	}

	@Override
	public double getWorkoutTime(int id) {
		List<WorkoutExercise> wes = (List<WorkoutExercise>) war.findAll();
		double totalTime = 0;
		
		for(WorkoutExercise we : wes) {
			if(we.getId().getWorkoutId() == id) 
				totalTime += we.getTime() * we.getSets();				
		}
		return totalTime;
	}
	
	@Override
	public Workout updateWorkout(Workout change) {
		return wr.save(change);
	}

	@Override
	public boolean deleteWorkout(Workout w) {
		try {
			wr.delete(w);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}




	
}
