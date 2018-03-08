package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Role;
import com.revature.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {

	@Autowired
	private RoleService rs;
	
	@GetMapping
	public List<Role> findAll() {
		return rs.findAll();
	}
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return rs.save(role);
	}
	
	@GetMapping("id/{id}")
	public Role findByRoleId(@PathVariable int id) {
		return rs.findByRoleId(id);
	}
	
	@PutMapping
	public void updateRole(@RequestBody Role role) {
		rs.update(role);
	}
	
	@PatchMapping("id/{id}")
	public void deleteRoleById(@PathVariable int id) {
		rs.deleteRoleById(id);
	}
}
