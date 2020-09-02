package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Role;
import com.revature.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository er;

	@Override
	public Role addRole(Role e) {
		return er.save(e);
	}

	@Override
	public Role getRole(int id) {
		return er.findById(id).get();
	}

	@Override
	public Role findByName(String name) {
		return er.findByName(name);
	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) er.findAll();
	}

	@Override
	public Role updateRole(Role change) {
		return er.save(change);
	}

	@Override
	public boolean deleteRole(Role e) {
		try {
			er.delete(e);
			return true;
		} catch (IllegalArgumentException er) {
			er.printStackTrace();
			return false;
		}
	}
}
