package com.revature.services;

import java.util.List;

import com.revature.beans.Permission;

public interface PermissionService {
	
	public Permission addPermission(Permission p);
	public Permission getPermission(int id);
	public Permission getPermissionByName(String name);
	public List<Permission> getAllPermissions();
	public Permission updatePermission(Permission change);
	public boolean deletePermission(Permission p);
	
}
