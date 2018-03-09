package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Quiz;
import com.revature.repos.QuizRepo;

@Service
public class QuizServiceImpl implements ServiceInterface<Quiz> {

	@Autowired
	private QuizRepo quizRepo;

	@Override
	@Transactional
	public List<Quiz> findAll() {
		return quizRepo.findAll();
	}

	@Override
	@Transactional
	public Quiz save(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	@Transactional
	public void update(Quiz quiz) {
		quizRepo.save(quiz);
	}

	@Override
	@Transactional
	public Quiz findById(int id) {
		return quizRepo.findByQuizId(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		quizRepo.deleteById(id);
	}
}