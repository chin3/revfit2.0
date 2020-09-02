package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository er;

	@Override
	public User addUser(User e) {
		return er.save(e);
	}

	@Override
	public User getUser(int id) {
		return er.findById(id).get();
	}

	@Override
	public User findByUsername(String username) {
		return er.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) er.findAll();
	}
	
	@Override
	public User login(String username, String password) {
		User u = er.findByUsername(username);
		if(u != null) {
			if(u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public User updateUser(User change) {
		return er.save(change);
	}

	@Override
	public boolean deleteUser(User e) {
		try {
			er.delete(e);
			return true;
		} catch (IllegalArgumentException er) {
			er.printStackTrace();
			return false;
		}
	}
}
