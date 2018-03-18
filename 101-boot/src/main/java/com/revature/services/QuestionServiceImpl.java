package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Question;
import com.revature.repos.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	@Transactional
	public List<Question> findAll() {
		return questionRepo.findAll();
	}

	@Override
	@Transactional
	public Question save(Question question) {
		return questionRepo.save(question);
	}

	@Override
	@Transactional
	public void update(Question question) {
		questionRepo.save(question);
	}

	@Override
	@Transactional
	public Question findById(int id) {
		return questionRepo.findByQuestionId(id);
	}
	
	@Override
	@Transactional
	public List<Question> findByQuizId(int id) {
		return questionRepo.findByQuizQuizId(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		questionRepo.deleteById(id);
	}
}
