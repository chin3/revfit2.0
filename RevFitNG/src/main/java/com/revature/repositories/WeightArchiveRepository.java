package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.WeightArchive;

@Repository
public interface WeightArchiveRepository extends CrudRepository<WeightArchive, Integer>{
	
}
