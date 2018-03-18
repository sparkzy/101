package com.revature.services;

import java.util.List;

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
	Flashcard save(Flashcard newFlashcard);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Flashcard findById(int id);
	List<Flashcard> findBySetId(int setId);
	List<Flashcard> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	void update(Flashcard updatedFlashcard);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
