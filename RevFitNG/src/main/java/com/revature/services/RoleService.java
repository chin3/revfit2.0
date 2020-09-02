package com.revature.services;

import java.util.List;

import com.revature.beans.Role;

public interface RoleService {
	public Role addRole(Role e);
	public Role getRole(int id);
	public Role findByName(String name);
	public List<Role> getAllRoles();
	public Role updateRole(Role change);
	public boolean deleteRole(Role e);
}
