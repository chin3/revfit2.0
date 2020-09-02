package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer>{
	Permission findByName(String name);
}
