package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByUsername(String username);

}
