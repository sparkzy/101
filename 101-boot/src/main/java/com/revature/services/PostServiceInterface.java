package com.revature.services;

import com.revature.entities.Post;

public interface PostServiceInterface extends ServiceInterface<Post> {
	Post findByAuthor(String author);
}
