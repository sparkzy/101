package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	Question findByQuestionId(int id);
	List<Question> findByQuizQuizId(int id);
}
