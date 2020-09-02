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

import com.revature.beans.Role;
import com.revature.services.RoleService;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class RoleController {
	
	@Autowired
	RoleService rs;
	
	@RequestMapping(value = "/Role", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Role addRole(@RequestBody Role r) {
		return rs.addRole(r);
	}
	
	@GetMapping(value = "/Role", produces = "application/json")
	public List<Role> allRole() {
		return rs.getAllRoles();
	}
	
	@GetMapping(value = "Role/{id}")
	public Role getRole(@PathVariable("id") int id) {
		return rs.getRole(id);
	}
	
	@GetMapping(value = "/Role/search")
	public Role findRole(@RequestParam(required = false) String name) {
		
		if(name != null) {
			return rs.findByName(name);
		}
		
		return null;
	}
	
	@PutMapping(value = "/Role/{id}", consumes = "application/json")
	public Role updateRole(@PathVariable("id") int id, @RequestBody Role change) {
		change.setId(id);
		return rs.updateRole(change);
	}
	
	@DeleteMapping(value = "/Role/{id}")
	public boolean deleteRole(@PathVariable("id") int id) {
		return rs.deleteRole(rs.getRole(id));
	}
}
