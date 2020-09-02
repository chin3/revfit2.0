package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.WorkoutExercise;
import com.revature.util.WorkoutExerciseId;

@Repository
public interface WorkoutExerciseRepository extends CrudRepository<WorkoutExercise, WorkoutExerciseId>{

}
