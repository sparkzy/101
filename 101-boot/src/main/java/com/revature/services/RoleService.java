package com.revature.services;

import java.util.List;

import com.revature.entities.Role;

public interface RoleService {

	List<Role> findAll();

	Role save(Role role);

	Role findByRoleId(int id);

	void update(Role role);

	void deleteRoleById(int id);
}