package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Flashcard;
import com.revature.services.FlashcardService;
import com.revature.services.ServiceInterface;

/**
* Flashcard Controller for 101
* Parses requests for 101 Flashcards
* 
* @author Bobby McGetrick
*
*/
@RestController
@RequestMapping("flashcards")
@CrossOrigin(origins = "http://localhost:4200")
public class FlashcardController {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private FlashcardService fcService;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new FlashcardController
	 */
	public FlashcardController() {
		super();
	}
	
	/**
	 * Create new FlashcardController with a pre-defined FlashcardService
	 * 
	 * @param FlashcardService fcService
	 */
	public FlashcardController(FlashcardService fcService) {
		super();
		this.fcService = fcService;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate FlashcardController hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fcService == null) ? 0 : fcService.hashCode());
		return result;
	}

	/**
	 * Check if FlashcardController is equivalent to another Object
	 *
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
		FlashcardController other = (FlashcardController) obj;
		if (fcService == null) {
			if (other.fcService != null)
				return false;
		} else if (!fcService.equals(other.fcService))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve FlashcardController.fcService
	 * 
	 * @return FlashcardService fcService
	 */
	public FlashcardService getFcService() {
		return fcService;
	}

	/**
	 * Set FlashcardController.fcService to a given FlashcardService
	 * 
	 * @param FlashcardService fcService
	 */
	public void setFcService(FlashcardService fcService) {
		this.fcService = fcService;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "FlashcardController [fcService=" + this.fcService + "]";
	}
	
	/************************************************************************************
	* Create
	************************************************************************************/
	/**
	 * Call FlashcardService's save() method and insert the given Flashcard into the 101
	 * database as a new Flascard
	 * 
	 * @param Flashcard newFc
	 * 
	 * @return Flashcard
	 */
	@PostMapping
	public Flashcard save(@RequestBody Flashcard newFc) {
		return fcService.save(newFc);
	}
	
	/************************************************************************************
	* Read
	************************************************************************************/
	/**
	 * Call FlashcardService's findById() method and return a Flashcard from the 101
	 * database with the corresponding flashcard_id
	 * 
	 * @param int id
	 * 
	 * @return Flashcard
	 */
	@GetMapping("id/{id}")
	public Flashcard findById(@PathVariable int id) {
		return fcService.findById(id);
	}
	
	/**
	 * Call FlashcardService's findBySetId() method and return all Flashcards from the 101
	 * database with the corresponding fc_set_id
	 * 
	 * @param int id
	 * 
	 * @return List<Flashcard>
	 */
	@GetMapping("set/{id}")
	public List<Flashcard> findBySetId(@PathVariable int id) {
		return fcService.findBySetId(id);
	}
	
	/**
	 * Call FlashcardService's findAll() method and return a List of all Flashcards in
	 * the 101 database
	 * 
	 * @return List<Flashcard>
	 */
	@GetMapping
	public List<Flashcard> findAll() {
		return fcService.findAll();
	}
	
	/************************************************************************************
	* Update
	************************************************************************************/
	/**
	 * Call FlashcardService's update() method and update a Flashcard from the 101
	 * database with the corresponding flashcard_id with the data from the given
	 * Flashcard
	 * 
	 * @param Flashcard updatedFc
	 */
	@PutMapping
	public void update(@RequestBody Flashcard updatedFc) {
		fcService.update(updatedFc);
	}
	
	/************************************************************************************
	* Delete
	************************************************************************************/
	/**
	 * Call FlashcardService's delete() method and delete a Flashcard from the 101
	 * database with the corresponding flashcard_id
	 * 
	 * @param int id
	 */
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		fcService.delete(id);
	}
	
}
