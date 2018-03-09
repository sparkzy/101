package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
	
	
	Subject findBysubjectId(int id);
	Subject deleteBysubjectId(int id);

	

}
