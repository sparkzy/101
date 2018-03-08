package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserId(int id);
}
