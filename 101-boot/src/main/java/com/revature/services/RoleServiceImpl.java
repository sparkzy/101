package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Role;
import com.revature.repos.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;

	@Override
	@Transactional
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	@Transactional
	public Role save(Role role) {
		return roleRepo.save(role);
	}

	@Override
	@Transactional
	public Role findByRoleId(int id) {
		return roleRepo.findByRoleId(id);
	}

	@Override
	@Transactional
	public void update(Role role) {
		roleRepo.save(role);
	}

	@Override
	@Transactional
	public void deleteRoleById(int id) {
		roleRepo.deleteById(id);
	}
}