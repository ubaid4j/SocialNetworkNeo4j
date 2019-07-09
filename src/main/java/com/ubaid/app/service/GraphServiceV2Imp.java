package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.app.dao.GraphDAOV2;
import com.ubaid.entity.User;

@Service
public class GraphServiceV2Imp implements GraphServiceV2
{
	
	@Autowired
	GraphDAOV2 graphDAOV2;

	@Override
	public void addAll(User[] users) throws RuntimeException
	{
		graphDAOV2.addAll(users);
	}

	@Override
	public void deleteAll() throws RuntimeException
	{
		graphDAOV2.deleteAll();
	}

}
