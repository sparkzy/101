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

import com.revature.entities.Role;
import com.revature.services.ServiceInterface;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins="http://localhost:4200")
public class RoleController {

	@Autowired
	private ServiceInterface<Role> si;
	
	@GetMapping
	public List<Role> findAll() {
		return si.findAll();
	}
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return si.save(role);
	}
	
	@GetMapping("id/{id}")
	public Role findByRoleId(@PathVariable int id) {
		return si.findById(id);
	}
	
	@PutMapping
	public void updateRole(@RequestBody Role role) {
		si.update(role);
	}
	
	@DeleteMapping("id/{id}")
	public void deleteRoleById(@PathVariable int id) {
		si.delete(id);
	}
}
