package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
	Post findByPostId(int id);
}
