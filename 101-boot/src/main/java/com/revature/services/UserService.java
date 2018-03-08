package com.revature.services;

import com.revature.entities.User;

public interface UserService extends ServiceInterface<User> {
	User login(User user);
}
