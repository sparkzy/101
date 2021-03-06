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

	@Transactional
	public User login(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		User dbUser = userRepo.findByUsername(username);
		if (username.equals(dbUser.getUsername())
				&& password.equals(dbUser.getPassword())) {
			return dbUser;
		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
}
