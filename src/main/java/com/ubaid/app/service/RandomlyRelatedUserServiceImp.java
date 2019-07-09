package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.app.dao.RandomlyRalatedUserDAO;
import com.ubaid.entity.User;

@Service
public class RandomlyRelatedUserServiceImp implements RandomlyRelatedUserService
{

	@Autowired
	RandomlyRalatedUserDAO randomRelatedUserDAO;
	
	@Override
	public User[] makeRandomlyRelatedUsers(int vertices, int edges) throws RuntimeException
	{
		return randomRelatedUserDAO.makeRendomlyRelatedUsers(vertices, edges);
	}

}
