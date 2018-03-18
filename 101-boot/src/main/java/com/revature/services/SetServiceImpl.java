package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.FlashcardSet;
import com.revature.repos.SetRepo;

/**
* Set Spring Service for 101
* Implements SetService
* Handles business logic for 101 Sets
* 
* @author Bobby McGetrick
*
*/
@Service
public class SetServiceImpl implements SetService {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private SetRepo setRepo;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new FlashcarServiceImpl
	 */
	public SetServiceImpl() {
		super();
	}

	/**
	 * Create new FlashcarServiceImpl with a pre-defined SetRepo
	 * 
	 * @param SetRepo fcRepo
	 */
	public SetServiceImpl(SetRepo fcRepo) {
		super();
		this.setRepo = fcRepo;
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate SetServiceImpl hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((setRepo == null) ? 0 : setRepo.hashCode());
		return result;
	}

	/**
	 * Check if SetServiceImpl is equivalent to another Object
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
		SetServiceImpl other = (SetServiceImpl) obj;
		if (setRepo == null) {
			if (other.setRepo != null)
				return false;
		} else if (!setRepo.equals(other.setRepo))
			return false;
		return true;
	}
	
	/************************************************************************************
	* Getters and Setters
	************************************************************************************/
	/**
	 * Retrieve SetServiceImpl.fcRepo
	 * 
	 * @return SetRepo fcRepo
	 */
	public SetRepo getFcRepo() {
		return setRepo;
	}

	/**
	 * Set SetServiceImpl.fcRepo to a given SetRepo
	 * 
	 * @param SetRepo fcRepo
	 */
	public void setFcRepo(SetRepo fcRepo) {
		this.setRepo = fcRepo;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "SetServiceImpl [setRepo=" + this.setRepo + "]";
	}
	
	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call SetRepos' save() method and insert the given Set into the 101
	 * database as a new Set
	 * 
	 * @param Set newSet
	 * 
	 * @return FlashcardSet
	 */
	@Override
	@Transactional
	public FlashcardSet save(FlashcardSet newFc) {
		return setRepo.save(newFc);
	}
	
	/**
	 * Call SetRepo's findById() method and return a Set in the 101 database
	 * with the corresponding id
	 * 
	 * @param int id
	 * 
	 * @return FlashcardSet
	 */
	@Override
	@Transactional
	public FlashcardSet findById(int id) {
		return setRepo.findByFcSetId(id);
	}
	
	/**
	 * Call SetRepo's findByTitle() method and return a Set wit the corresponding title
	 * in the 101 database
	 * 
	 * @return FlashcardSet
	 */
	@Override
	@Transactional
	public FlashcardSet findByTitle(String title) {
		return setRepo.findByTitle(title);
	}
	
	/**
	 * Call SetRepo's findByStatusStatusName() method and return a Set in the 101 database
	 * with the corresponding id
	 * 
	 * @param String status
	 * 
	 * @return List<FlashcardSet>
	 */
	@Override
	@Transactional
	public List<FlashcardSet> findByNotStatus(String status) {
		return setRepo.findByStatusStatusNameNotLike(status);
	}
	
	/**
	 * Call SetRepo's findAll() method and return a List of all Sets in
	 * the 101 database
	 * 
	 * @return List<FlashcardSets>
	 */
	@Override
	@Transactional
	public List<FlashcardSet> findAll() {
		return setRepo.findAll();
	}

	/**
	 * Call SetRepo's update() method and update a Set from the 101
	 * database with the corresponding set_id with the data from the given
	 * Set
	 * 
	 * @param FlashcardSet updatedSet
	 * 
	 * @return FlashcardSet
	 */
	@Override
	@Transactional
	public void update(FlashcardSet updatedFc) {
		setRepo.save(updatedFc);
	}

	/**
	 * Call SetRepo's delete() method and delete a Set from the 101
	 * database with the corresponding set_id
	 * 
	 * @param int id
	 */
	@Override
	@Transactional
	public void delete(int id) {
		setRepo.deleteById(id);
	}
	
	/************************************************************************************
	* Methods
	************************************************************************************/
	

}
