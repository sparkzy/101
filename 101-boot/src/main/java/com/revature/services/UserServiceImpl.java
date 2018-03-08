package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.User;
import com.revature.repos.UserRepo;

@Service
public class UserServiceImpl implements ServiceInterface<User> {

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

	@Override
	@Transactional
	public void update(User user) {
		userRepo.save(user);
	}

	@Override
	@Transactional
	public User findById(int id) {
		return userRepo.findByUserId(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		userRepo.deleteById(id);
	}
}
