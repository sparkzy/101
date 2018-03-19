package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Post;
import com.revature.repos.PostRepo;

/**
* Post Spring Service for 101
* Implements PostService
* Handles business logic for 101 Posts
* 
* @author Bobby McGetrick
*
*/
@Service
public class PostServiceImpl implements PostServiceInterface {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	@Autowired
	private PostRepo postRepo;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new FlashcarServiceImpl
	 */
	public PostServiceImpl() {
		super();
	}

	/**
	 * Create new FlashcarServiceImpl with a pre-defined PostRepo
	 * 
	 * @param PostRepo fcRepo
	 */
	public PostServiceImpl(PostRepo fcRepo) {
		super();
		this.postRepo = fcRepo;
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate PostServiceImpl hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postRepo == null) ? 0 : postRepo.hashCode());
		return result;
	}

	/**
	 * Check if PostServiceImpl is equivalent to another Object
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
		PostServiceImpl other = (PostServiceImpl) obj;
		if (postRepo == null) {
			if (other.postRepo != null)
				return false;
		} else if (!postRepo.equals(other.postRepo))
			return false;
		return true;
	}
	
	/************************************************************************************
	* Getters and Postters
	************************************************************************************/
	/**
	 * Retrieve PostServiceImpl.fcRepo
	 * 
	 * @return PostRepo fcRepo
	 */
	public PostRepo getPostRepo() {
		return postRepo;
	}

	/**
	 * Post PostServiceImpl.fcRepo to a given PostRepo
	 * 
	 * @param PostRepo fcRepo
	 */
	public void setPostRepo(PostRepo fcRepo) {
		this.postRepo = fcRepo;
	}
	
	/************************************************************************************
	* toString()
	************************************************************************************/
	public String toString() {
		return "PostServiceImpl [postRepo=" + this.postRepo + "]";
	}
	
	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call PostRepos' save() method and insert the given Post into the 101
	 * database as a new Post
	 * 
	 * @param Post newPost
	 * 
	 * @return Post
	 */
	@Override
	@Transactional
	public Post save(Post newPost) {
		return postRepo.save(newPost);
	}
	
	/**
	 * Call PostRepo's findById() method and return a Post in the 101 database
	 * with the corresponding id
	 * 
	 * @param int id
	 * 
	 * @return Post
	 */
	@Override
	@Transactional
	public Post findById(int id) {
		return postRepo.findByPostId(id);
	}
	
	/**
	 * Call PostRepo's findAll() method and return a List of all Posts in
	 * the 101 database
	 * 
	 * @return List<Posts>
	 */
	@Override
	@Transactional
	public List<Post> findAll() {
		return postRepo.findAll();
	}

	/**
	 * Call PostRepo's update() method and update a Post from the 101
	 * database with the corresponding post_id with the data from the given
	 * Post
	 * 
	 * @param Post updatedPost
	 */
	@Override
	@Transactional
	public void update(Post updatedPost) {
		postRepo.save(updatedPost);
	}

	/**
	 * Call PostRepo's delete() method and delete a Post from the 101
	 * database with the corresponding post_id
	 * 
	 * @param int id
	 */
	@Override
	@Transactional
	public void delete(int id) {
		postRepo.deleteById(id);
	}

	

	@Override
	@Transactional
	public Post findByAuthor(String author) {
		return postRepo.findByAuthor(author);
		
	}

}
