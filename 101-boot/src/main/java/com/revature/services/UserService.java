package com.revature.services;

import java.util.List;

import com.revature.entities.User;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User findByUserId(int id);

	void update(User user);

	void deleteUserById(int id);
}
