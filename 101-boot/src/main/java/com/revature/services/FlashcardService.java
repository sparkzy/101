package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.entities.Flashcard;

/**
* Flashcard Service Interface for 101
* 
* @author Bobby McGetrick
*
*/
public interface FlashcardService {

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	Flashcard save(Flashcard newFc);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Flashcard findById(int id);
	List<Flashcard> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
//	Flashcard update(Flashcard updatedFc);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);
	
}
