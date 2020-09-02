package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Permission;
import com.revature.services.PermissionService;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class PermissionController {

	@Autowired
	PermissionService ps;
	
	@RequestMapping(value = "/Permission", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Permission addPermission(@RequestBody Permission p) {
		return ps.addPermission(p);
	}
	
	@GetMapping(value = "/Permission", produces = "application/json")
	public List<Permission> allPermission() {
		return ps.getAllPermissions();
	}
	
	@GetMapping(value = "Permission/{id}")
	public Permission getPermission(@PathVariable("id") int id) {
		return ps.getPermission(id);
	}
	
	@GetMapping(value = "/Permission/search")
	public Permission findPermission(@RequestParam(required = false) String name) {
		
		if(name != null) {
			return ps.getPermissionByName(name);
		}
		
		return null;
	}
	
	@PutMapping(value = "/Permission/{id}", consumes = "application/json")
	public Permission updatePermission(@PathVariable("id") int id, @RequestBody Permission change) {
		change.setId(id);
		return ps.updatePermission(change);
	}
	
	@DeleteMapping(value = "/Permission/{id}")
	public boolean deletePermission(@PathVariable("id") int id) {
		return ps.deletePermission(ps.getPermission(id));
	}
}
