package com.revature.repos;

import java.util.List;

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
	List<Flashcard> findByFcSetFcSetId(int setId);
}
