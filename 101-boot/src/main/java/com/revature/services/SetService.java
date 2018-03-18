package com.revature.services;

import java.util.List;

import com.revature.entities.FlashcardSet;

/**
* FlashcardSet Service Interface for 101
* 
* @author Bobby McGetrick
*
*/
public interface SetService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	FlashcardSet save(FlashcardSet newFlashcardSet);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	FlashcardSet findById(int id);
	FlashcardSet findByTitle(String title);
	List<FlashcardSet> findByNotStatus(String status);
	List<FlashcardSet> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	void update(FlashcardSet updatedFlashcardSet);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
