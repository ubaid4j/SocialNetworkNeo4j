package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.User.User;
import com.ubaid.app.dao.UserDAO;

@Service
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
