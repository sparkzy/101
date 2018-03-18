package com.revature.services;

import java.util.List;

import com.revature.entities.Question;

/**
* Quetion Service Interface for 101
* 
* @author Bobby McGetrick
*
*/
public interface QuestionService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	Question save(Question newQuestion);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Question findById(int id);
	List<Question> findByQuizId(int id);
	List<Question> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	void update(Question updatedQuestion);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
