package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.dao.UserDAO;
import com.ubaid.user.User;

@Component
public class UserGenService implements UserService
{

	@Autowired
	UserDAO userdao;
	
	@Override
	public User[] getUsers(int quantity)
	{
		return userdao.getUsers(quantity);
	}

}
