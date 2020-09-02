package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Permission;
import com.revature.repositories.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository pr;
	
	@Override
	public Permission addPermission(Permission p) {
		return pr.save(p);
	}

	@Override
	public Permission getPermission(int id) {
		return pr.findById(id).get();
	}

	@Override
	public Permission getPermissionByName(String name) {
		return pr.findByName(name);
	}
	@Override
	public List<Permission> getAllPermissions() {
		return (List<Permission>) pr.findAll();
	}

	@Override
	public Permission updatePermission(Permission change) {
		return pr.save(change);
	}

	@Override
	public boolean deletePermission(Permission p) {
		try {
			pr.delete(p);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
