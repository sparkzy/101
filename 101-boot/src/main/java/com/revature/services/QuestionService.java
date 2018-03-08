package com.revature.services;

import java.util.List;

import com.revature.entities.Question;

public interface QuestionService {

	List<Question> findAll();

	Question save(Question question);

	Question findByQuestionId(int id);

	void update(Question question);

	void deleteQuestionById(int id);
}