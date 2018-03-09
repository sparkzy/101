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

import com.revature.entities.Quiz;
import com.revature.services.ServiceInterface;

@RestController
@RequestMapping("quizzes")
@CrossOrigin(origins="http://localhost:4200")
public class QuizController {

	@Autowired
	private ServiceInterface<Quiz> si;
	
	@GetMapping
	public List<Quiz> findAll() {
		return si.findAll();
	}
	
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return si.save(quiz);
	}
	
	@GetMapping("id/{id}")
	public Quiz findByQuizId(@PathVariable int id) {
		return si.findById(id);
	}
	
	@PutMapping
	public void updateQuiz(@RequestBody Quiz quiz) {
		si.update(quiz);
	}
	
	@DeleteMapping("id/{id}")
	public void deleteQuizById(@PathVariable int id) {
		si.delete(id);
	}
}
