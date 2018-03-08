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

import com.revature.entities.Question;
import com.revature.services.ServiceInterface;

@RestController
@RequestMapping("questions")
@CrossOrigin(origins="http://localhost:4200")
public class QuestionController {

	@Autowired
	private ServiceInterface<Question> si;

	@GetMapping
	public List<Question> findAll() {
		return si.findAll();
	}

	@PostMapping
	public Question createQuestion(@RequestBody Question question) {
		return si.save(question);
	}

	@GetMapping("id/{id}")
	public Question findByQuestionId(@PathVariable int id) {
		return si.findById(id);
	}

	@PutMapping
	public void updateQuestion(@RequestBody Question question) {
		si.update(question);
	}

	@DeleteMapping("id/{id}")
	public void deleteQuestionById(@PathVariable int id) {
		si.delete(id);
	}
}
