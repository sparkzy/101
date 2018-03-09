package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	Question findByQuestionId(int id);
}
