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

import com.revature.entities.FlashcardSet;
import com.revature.services.ServiceInterface;
import com.revature.services.SetServiceImpl;

/**
* Set Controller for 101
* Parses requests for 101 Sets
* 
* @author Bobby McGetrick
*
*/
@RestController
@RequestMapping("sets")
@CrossOrigin(origins = "http://localhost:4200")
public class SetController {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private ServiceInterface<FlashcardSet> setService;
	@Autowired
	private SetServiceImpl ssi = new SetServiceImpl();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new SetController
	 */
	public SetController() {
		super();
	}
	
	/**
	 * Create new SetController with a pre-defined ServiceInterface<FlashcardSet>
	 * 
	 * @param ServiceInterface<FlashcardSet> setService
	 */
	public SetController(ServiceInterface<FlashcardSet> setService) {
		super();
		this.setService = setService;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate SetController hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((setService == null) ? 0 : setService.hashCode());
		return result;
	}

	/**
	 * Check if SetController is equivalent to another Object
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
		SetController other = (SetController) obj;
		if (setService == null) {
			if (other.setService != null)
				return false;
		} else if (!setService.equals(other.setService))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve SetController.setService
	 * 
	 * @return ServiceInterface<FlashcardSet> setService
	 */
	public ServiceInterface<FlashcardSet> getSetService() {
		return setService;
	}

	/**
	 * Set SetController.setService to a given ServiceInterface<FlashcardSet>
	 * 
	 * @param ServiceInterface<FlashcardSet> setService
	 */
	public void setSetService(ServiceInterface<FlashcardSet> setService) {
		this.setService = setService;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "SetController [setService=" + this.setService + "]";
	}
	
	/************************************************************************************
	* Create
	************************************************************************************/
	/**
	 * Call SetService's save() method and insert the given Set into the 101
	 * database as a new FlashcardSet
	 * 
	 * @param FlashcardSet newSet
	 * 
	 * @return FlashcardSet
	 */
	@PostMapping
	public FlashcardSet save(@RequestBody FlashcardSet newSet) {
		System.out.println("#######  + " + newSet.getAuthor() + " #######");
		return setService.save(newSet);
	}
	
	/************************************************************************************
	* Read
	************************************************************************************/
	/**
	 * Call SetService's findById() method and return a Set from the 101
	 * database with the corresponding set_id
	 * 
	 * @param int id
	 * 
	 * @return FlashcardSet
	 */
	@GetMapping("id/{id}")
	public FlashcardSet findById(@PathVariable int id) {
		return setService.findById(id);
	}
	
	/**
	 * Call SetService's findAll() method and return a List of all Sets in
	 * the 101 database
	 * 
	 * @return List<FlashcardSet>
	 */
	@GetMapping
	public List<FlashcardSet> findAll() {
		return setService.findAll();
	}
	
	/**
	 * Call SetService's findByTitle() method and return a Sets with the corresponding title
	 * in the 101 database
	 * 
	 * @return FlashcardSet
	 */
	@GetMapping("title/{title}")
	public FlashcardSet findByTitle(@PathVariable String title) {
		return ssi.findByTitle(title);
	}
	
	/************************************************************************************
	* Update
	************************************************************************************/
	/**
	 * Call SetService's update() method and update a Set from the 101
	 * database with the corresponding set_id with the data from the given
	 * Set
	 * 
	 * @param Set updatedSet
	 * 
	 * @return Set
	 */
	@PutMapping
	public void update(@RequestBody FlashcardSet updatedSet) {
		setService.update(updatedSet);
	}
	
	/************************************************************************************
	* Delete
	************************************************************************************/
	/**
	 * Call SetService's delete() method and delete a Set from the 101
	 * database with the corresponding set_id with the data from the given
	 * Set
	 * 
	 * @param int id
	 */
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		setService.delete(id);
	}
	
}
