package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
	List<FlashcardSet> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
//	FlashcardSet update(FlashcardSet updatedFlashcardSet);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);
	
}
