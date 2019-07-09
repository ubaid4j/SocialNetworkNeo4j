package com.ubaid.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubaid.User.User;
import com.ubaid.app.dao.generator.UserGenerator;

@Repository
public class UserDAOImp implements UserDAO
{

	@Autowired
	private UserGenerator generator;
	
	@Override
	public User[] getUsers(int quantity)
	{
		return generator.generateUsers(quantity);
	}

}
