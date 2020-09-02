package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer>{
	public Exercise findByName(String name);
}
