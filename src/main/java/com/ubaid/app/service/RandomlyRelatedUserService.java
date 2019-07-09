package com.ubaid.app.service;

import com.ubaid.entity.User;

/**
 * provide a random relationship between the users
 * @author UbaidurRehman
 *
 */
public interface RandomlyRelatedUserService
{
	public User[] makeRandomlyRelatedUsers(int vertices, int edges) throws RuntimeException;
}
