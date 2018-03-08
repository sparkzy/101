package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Status;
import com.revature.entities.Subject;
import com.revature.services.ServiceInterface;


@RestController
@RequestMapping("subjects")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
	@Autowired
	private ServiceInterface<Subject> ss;
	
	@PostMapping
	public Subject createSubject(@RequestBody Subject subject) {
		return ss.save(subject);
	}
	@GetMapping
	public List<Subject> findAll() {
		return ss.findAll();
	}
	
	@GetMapping("id/{id}")
	public Subject findById(@PathVariable Integer id) {
		return ss.findById(id);
	}
	public void updateStatus(@RequestBody Subject s) {
		ss.update(s);
	}
	@DeleteMapping
	public void deleteStatus(@PathVariable int id) {
		ss.delete(id);
	}
	

}
