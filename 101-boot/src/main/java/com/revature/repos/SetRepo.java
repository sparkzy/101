package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.FlashcardSet;

public interface SetRepo extends JpaRepository<FlashcardSet, Integer> {
	FlashcardSet findByFcSetId(int id);

	FlashcardSet findByTitle(String title);
	
	List<FlashcardSet> findByStatusStatusNameNotLike(String statusName);
}
