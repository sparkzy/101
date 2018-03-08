package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.User;
import com.revature.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}
}
