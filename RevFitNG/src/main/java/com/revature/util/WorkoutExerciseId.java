package com.revature.util;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WorkoutExerciseId implements Serializable{
	
	private int workout_id;
	private int exercise_id;
	
	
	public WorkoutExerciseId() {
		super();
	}

	public WorkoutExerciseId(int workout_id, int exercise_id) {
		super();
		this.workout_id = workout_id;
		this.exercise_id = exercise_id;
	}

	public int getWorkoutId() {
		return workout_id;
	}

	public void setWorkoutId(int workout_id) {
		this.workout_id = workout_id;
	}

	public int getExerciseId() {
		return exercise_id;
	}

	public void setExerciseId(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + exercise_id;
		result = prime * result + workout_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutExerciseId other = (WorkoutExerciseId) obj;
		if (exercise_id != other.exercise_id)
			return false;
		if (workout_id != other.workout_id)
			return false;
		return true;
	}
	
	
	
}
