package com.ubaid.app.dao;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubaid.app.service.UserService;
import com.ubaid.entity.User;


@Repository
public class RandomlyRelatedUserDAOImp implements RandomlyRalatedUserDAO
{


	@Autowired
	UserService userGenService;
	
	@Autowired
	Random random;
	
	@Override
	public User[] makeRendomlyRelatedUsers(int vertices, int edges)
	{
		User[] users = userGenService.getUsers(vertices);
		
		for(int i = 0; i < edges; i++)
		{
			User user1 = users[random.nextInt(vertices)];
			User user2 = users[random.nextInt(vertices)];

			if(!user1.equals(user2))
			{
				user1.addFollower(user2);
			}
		}
		
		return users;
	}

}
