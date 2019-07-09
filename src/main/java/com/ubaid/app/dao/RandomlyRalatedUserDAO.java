package com.ubaid.app.dao;

import com.ubaid.entity.User;

/**
 * this class will call service to get users and then randomly related (follow) them
 * @author UbaidurRehman
 *
 */
public interface RandomlyRalatedUserDAO
{
	/**
	 * 
	 * @param vertices
	 * @param edges
	 * 
	 * vertices will indicate users and edges will indicate their relationships
	 * 
	 * @return array of Users
	 */
	public User[] makeRendomlyRelatedUsers(int vertices, int edges);
}
