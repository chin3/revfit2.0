package com.revature.services;

import java.util.List;

import com.revature.beans.User;

public interface UserService {
	public User addUser(User e);
	public User getUser(int id);
	public User findByUsername(String username);
	public User login(String username, String password);
	public List<User> getAllUsers();
	public User updateUser(User change);
	public boolean deleteUser(User e);
}
