package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.util.UsernamePassword;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserService us;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User u) {
		return us.addUser(u);
	}
	
	@GetMapping(value = "/user", produces = "application/json")
	public List<User> allUser() {
		return us.getAllUsers();
	}
	
	@GetMapping(value = "user/{id}")
	public User getUser(@PathVariable("id") int id) {
		return us.getUser(id);
	}
	
	@PostMapping(value = "/user/login", produces = "application/json", consumes = "application/json")
	public User findUser(@RequestBody UsernamePassword up) {
		if(up != null) {
			return us.login(up.getUsername(), up.getPassword());
		}
		
		return null;
	}
	
	@PutMapping(value = "/user/{id}", consumes = "application/json")
	public User updateUser(@PathVariable("id") int id, @RequestBody User change) {
		change.setId(id);
		return us.updateUser(change);
	}
	
	@DeleteMapping(value = "/user/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		return us.deleteUser(us.getUser(id));
	}
	
}
