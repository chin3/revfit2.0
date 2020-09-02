package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {

	@Id
	@GeneratedValue
	@Column(name = "exercise_id")
	private int id;
	
	@Column(name = "muscle_group")
	private String muscleGroup;
	
	private String name;
	private int calories;
	
	public Exercise(int id, String muscleGroup, String name, int calories) {
		super();
		this.id = id;
		this.muscleGroup = muscleGroup;
		this.name = name;
		this.calories = calories;
	}
	
	public Exercise(String muscleGroup, String name, int calories) {
		super();
		this.muscleGroup = muscleGroup;
		this.name = name;
		this.calories = calories;
	}
	
	public Exercise() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", muscleGroup=" + muscleGroup + ", name=" + name + ", calories=" + calories
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + id;
		result = prime * result + ((muscleGroup == null) ? 0 : muscleGroup.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Exercise other = (Exercise) obj;
		if (calories != other.calories)
			return false;
		if (id != other.id)
			return false;
		if (muscleGroup == null) {
			if (other.muscleGroup != null)
				return false;
		} else if (!muscleGroup.equals(other.muscleGroup))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
