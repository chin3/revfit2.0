package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	public Role findByName(String name);

}
