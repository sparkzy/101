package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.FlashcardSet;

public interface SetRepo extends JpaRepository<FlashcardSet, Integer> {
	FlashcardSet findByFcSetId(int id);

	FlashcardSet findByTitle(String title);
}
