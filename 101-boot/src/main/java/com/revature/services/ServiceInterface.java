package com.revature.services;

import java.util.List;

/**
* Generic Service Interface for 101
* 
* @author Bobby McGetrick
*
*/
public interface ServiceInterface<T> {

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	T save(T newT);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	T findById(int id);
	List<T> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	void update(T updatedT);
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);
	
}
