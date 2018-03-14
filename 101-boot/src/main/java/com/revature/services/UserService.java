package com.revature.services;

import com.revature.entities.User;

public interface UserService extends ServiceInterface<User> {
	User login(User user);

	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
}