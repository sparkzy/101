package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping
	public List<User> findAll() {
		return us.findAll();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return us.save(user);
	}

	@GetMapping("id/{id}")
	public User findByUserId(@PathVariable int id) {
		return us.findByUserId(id);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) {
		us.update(user);
	}

	@PatchMapping("id/{id}")
	public void deleteUserById(@PathVariable int id) {
		us.deleteUserById(id);
	}
}
