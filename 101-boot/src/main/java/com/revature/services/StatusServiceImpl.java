package com.revature.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.entities.Status;
import com.revature.repos.StatusRepo;
@Service
public class StatusServiceImpl implements ServiceInterface<Status> {
	@Autowired
	private StatusRepo statRepo;

	@Override
	@Transactional 
	public Status save(Status s) {
		return statRepo.save(s);
	}

	
	@Override
	@Transactional
	public Status findById(int id) {
		return statRepo.findBystatusId(id);
	}

	@Override
	@Transactional
	public List<Status> findAll() {
		
		 return statRepo.findAll();
	}

	@Override
	@Transactional
	public void update(Status s) {
		 statRepo.save(s);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		statRepo.deleteById(id);
		
	}

	

	
}
