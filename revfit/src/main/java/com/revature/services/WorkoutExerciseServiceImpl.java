package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.WorkoutExercise;
import com.revature.repositories.WorkoutExerciseRepository;
import com.revature.util.WorkoutExerciseId;

@Service
public class WorkoutExerciseServiceImpl implements WorkoutExerciseService {

	@Autowired
	WorkoutExerciseRepository wer;

	
	@Override
	public List<WorkoutExercise> addWorkoutExercise(List<WorkoutExercise> wes) {
		return (List<WorkoutExercise>) wer.saveAll(wes);
	}

	@Override
	public WorkoutExercise getWorkoutExercise(WorkoutExerciseId id) {
		return wer.findById(id).get();
  }

	@Override
	public List<WorkoutExercise> getAllWorkoutExercises() {
		return (List<WorkoutExercise>) wer.findAll();
	}
	
	@Override
	public List<WorkoutExercise> getAllByWorkout(int wid) {
		List<WorkoutExercise> wes = (List<WorkoutExercise>) wer.findAll();
		List<WorkoutExercise> returns = new ArrayList<WorkoutExercise>();
		
		for(WorkoutExercise w : wes) {
			if(w.getId().getWorkoutId() == wid) {
				returns.add(w);
			}
		}
		return returns;
	}

	@Override
	public WorkoutExercise updateWorkoutExercise(WorkoutExercise change) {
		return wer.save(change);
	}

	@Override
	public boolean deleteWorkoutExercise(WorkoutExercise e) {
		try {
			wer.delete(e);
			return true;
		} catch (IllegalArgumentException er) {
			er.printStackTrace();
			return false;
		}
	}

}
