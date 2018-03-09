package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.entities.Status;
import com.revature.entities.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
	
	
	Subject findBysubjectId(int id);
	Subject deleteBysubjectId(int id);

	

}
