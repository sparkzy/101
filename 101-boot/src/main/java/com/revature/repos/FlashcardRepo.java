package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Flashcard;

/**
* Flashcard Repository Interface for 101
* Extends JpaReopsitory<Flashcard, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface FlashcardRepo extends JpaRepository<Flashcard, Integer> {
	Flashcard findByFlashcardId(int id);
//	Flashcard update(Flashcard updatedFc);
}
