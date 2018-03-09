package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Post;
import com.revature.services.ServiceInterface;

/**
* Post Controller for 101
* Parses requests for 101 Posts
* 
* @author Bobby McGetrick
*
*/
@RestController
@RequestMapping("posts")
public class PostController {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private ServiceInterface<Post> postService;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new PostController
	 */
	public PostController() {
		super();
	}
	
	/**
	 * Create new PostController with a pre-defined PostService
	 * 
	 * @param PostService postService
	 */
	public PostController(ServiceInterface<Post> postService) {
		super();
		this.postService = postService;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate PostController hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postService == null) ? 0 : postService.hashCode());
		return result;
	}

	/**
	 * Check if PostController is equivalent to another Object
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
		PostController other = (PostController) obj;
		if (postService == null) {
			if (other.postService != null)
				return false;
		} else if (!postService.equals(other.postService))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve PostController.postService
	 * 
	 * @return ServiceInterface<Post> postService
	 */
	public ServiceInterface<Post> getPostService() {
		return postService;
	}

	/**
	 * Post PostController.postService to a given PostService
	 * 
	 * @param ServiceInterface<Post> postService
	 */
	public void setPostService(ServiceInterface<Post> postService) {
		this.postService = postService;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "PostController [postService=" + this.postService + "]";
	}
	
	/************************************************************************************
	* Create
	************************************************************************************/
	/**
	 * Call PostService's save() method and insert the given Post into the 101
	 * database as a new Post
	 * 
	 * @param Post newPost
	 * 
	 * @return Post
	 */
	@PostMapping
	public Post save(@RequestBody Post newPost) {
		return postService.save(newPost);
	}
	
	/************************************************************************************
	* Read
	************************************************************************************/
	/**
	 * Call PostService's findById() method and return a Post from the 101
	 * database with the corresponding post_id
	 * 
	 * @param int id
	 * 
	 * @return Post
	 */
	@GetMapping("id/{id}")
	public Post findById(@PathVariable int id) {
		return postService.findById(id);
	}
	
	/**
	 * Call PostService's findAll() method and return a List of all Posts in
	 * the 101 database
	 * 
	 * @return List<Post>
	 */
	@GetMapping
	public List<Post> findAll() {
		System.out.println("######### CONTROLLER ##########");
		return postService.findAll();
	}
	
	/************************************************************************************
	* Update
	************************************************************************************/
	/**
	 * Call PostService's update() method and update a Post from the 101
	 * database with the corresponding post_id with the data from the given
	 * Post
	 * 
	 * @param Post updatedPost
	 * 
	 * @return Post
	 */
	@PutMapping
	public void findById(@RequestBody Post updatedPost) {
		postService.update(updatedPost);
	}
	
	/************************************************************************************
	* Delete
	************************************************************************************/
	/**
	 * Call PostService's delete() method and delete a Post from the 101
	 * database with the corresponding post_id with the data from the given
	 * Post
	 * 
	 * @param int id
	 */
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		postService.delete(id);
	}

}
