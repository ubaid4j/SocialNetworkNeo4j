package com.ubaid.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.dao.generator.UserGenerator;
import com.ubaid.user.User;

@Component
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
