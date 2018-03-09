package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	Quiz findByQuizId(int id);
}
