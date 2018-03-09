package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Subject;

import com.revature.repos.SubjectRepo;
@Service
public class SubjectServiceImpl implements ServiceInterface<Subject>{
	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	@Transactional 
	public Subject save(Subject s) {
		return subjectRepo.save(s);
	}

	
	@Override
	@Transactional
	public Subject findById(int id) {
		return subjectRepo.findBysubjectId(id);
	}

	@Override
	@Transactional
	public List<Subject> findAll() {
		
		 return subjectRepo.findAll();
	}

	@Override
	@Transactional
	public void update(Subject s) {
		subjectRepo.save(s);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		subjectRepo.deleteById(id);
		
	}
	
	

}
