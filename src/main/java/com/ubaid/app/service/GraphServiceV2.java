package com.ubaid.app.service;

import com.ubaid.entity.User;

/**
 * 
 * Its first implementation GraphService is deprecated
 * it has one method addAll[User[]] to add users
 * 
 * 
 * @author UbaidurRehman
 *
 */
public interface GraphServiceV2
{
	/**
	 * 
	 * @param users
	 * 
	 * all all users in the database
	 * 
	 * @throws RuntimeException
	 */
	public void addAll(User[] users) throws RuntimeException;
}
