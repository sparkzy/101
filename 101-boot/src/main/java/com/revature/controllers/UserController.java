package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.services.ServiceInterface;

@RestController
@RequestMapping("users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private ServiceInterface<User> si;

	@GetMapping
	public List<User> findAll() {
		return si.findAll();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return si.save(user);
	}

	@GetMapping("id/{id}")
	public User findByUserId(@PathVariable int id) {
		return si.findById(id);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) {
		si.update(user);
	}

	@DeleteMapping("id/{id}")
	public void deleteUserById(@PathVariable int id) {
		si.delete(id);
	}
}
