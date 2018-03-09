package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.entities.Flashcard;
import com.revature.repos.FlashcardRepo;

/**
* Flashcard Spring Service for 101
* Implements FlashcardService
* Handles business logic for 101 Flashcards
* 
* @author Bobby McGetrick
*
*/
@Service
public class FlashcardServiceImpl implements ServiceInterface<Flashcard> {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private FlashcardRepo fcRepo;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new FlashcarServiceImpl
	 */
	public FlashcardServiceImpl() {
		super();
	}

	/**
	 * Create new FlashcarServiceImpl with a pre-defined FlashcardRepo
	 * 
	 * @param FlashcardRepo fcRepo
	 */
	public FlashcardServiceImpl(FlashcardRepo fcRepo) {
		super();
		this.fcRepo = fcRepo;
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate FlashcardServiceImpl hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fcRepo == null) ? 0 : fcRepo.hashCode());
		return result;
	}

	/**
	 * Check if FlashcardServiceImpl is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlashcardServiceImpl other = (FlashcardServiceImpl) obj;
		if (fcRepo == null) {
			if (other.fcRepo != null)
				return false;
		} else if (!fcRepo.equals(other.fcRepo))
			return false;
		return true;
	}
	
	/************************************************************************************
	* Getters and Setters
	************************************************************************************/
	/**
	 * Retrieve FlashcardServiceImpl.fcRepo
	 * 
	 * @return FlashcardRepo fcRepo
	 */
	public FlashcardRepo getFcRepo() {
		return fcRepo;
	}

	/**
	 * Set FlashcardServiceImpl.fcRepo to a given FlashcardRepo
	 * 
	 * @param FlashcardRepo fcRepo
	 */
	public void setFcRepo(FlashcardRepo fcRepo) {
		this.fcRepo = fcRepo;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "FlashcardServiceImpl [fcRepo=" + this.fcRepo + "]";
	}
	
	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call FlashcardRepos' save() method and insert the given Flashcard into the 101
	 * database as a new Flascard
	 * 
	 * @param Flashcard newFc
	 * 
	 * @return Flashcard
	 */
	@Override
	@Transactional
	@PostMapping
	public Flashcard save(Flashcard newFc) {
		return fcRepo.save(newFc);
	}
	
	/**
	 * Call FlashcardRepo's findById() method and return a Flashcard in the 101 database
	 * with the corresponding id
	 * 
	 * @param int id
	 * 
	 * @return Flashcard
	 */
	@Override
	@Transactional
	public Flashcard findById(int id) {
		return fcRepo.findByFlashcardId(id);
	}
	
	/**
	 * Call FlashcardRepo's findAll() method and return a List of all Flashcards in
	 * the 101 database
	 * 
	 * @return List<Flashcards>
	 */
	@Override
	@Transactional
	public List<Flashcard> findAll() {
		return fcRepo.findAll();
	}

	/**
	 * Call FlashcardRepo's update() method and update a Flashcard from the 101
	 * database with the corresponding flashcard_id with the data from the given
	 * Flashcard
	 * 
	 * @param Flashcard updatedFc
	 */
	@Override
	@Transactional
	public void update(Flashcard updatedFc) {
		fcRepo.save(updatedFc);
	}

	/**
	 * Call FlashcardRepo's delete() method and delete a Flashcard from the 101
	 * database with the corresponding flashcard_id
	 * 
	 * @param int id
	 */
	@Override
	@Transactional
	public void delete(int id) {
		fcRepo.deleteById(id);
	}

}
