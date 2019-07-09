package com.ubaid.app.dao;

import com.ubaid.entity.User;

/**
 * 
 * GraphDAO is deprecated
 * it has method allAll(User[]) to add all users and return true if add all
 * and throws exception if there is any exception
 * 
 * @author UbaidurRehman
 *
 */
public interface GraphDAOV2
{
	/**
	 * 
	 * @param users
	 * 
	 * this method add all users in the database 
	 * @throws RuntimeException
	 */
	public void addAll(User[] users) throws RuntimeException;
	
	/**
	 * this method will delete all nodes and their relations
	 * in the database
	 * @throws RuntimeException
	 */
	public void deleteAll() throws RuntimeException;
}
