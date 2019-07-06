package com.ubaid.app.dao;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.dao.graph.SocialGraph;
import com.ubaid.app.service.UserService;
import com.ubaid.user.User;

@Component
public class SocialGraphDAO implements GraphDAO
{

	@Autowired
	private SocialGraph graph;
	
	@Autowired
	private UserService userGen;

	@Autowired
	private Random random;
	
	@Override
	public SocialGraph getDefaultGraph()
	{
		return populateGraph(20, 20);
	}

	@Override
	public SocialGraph getCustomGraph(int vertices, int edges)
	{
		return populateGraph(vertices, edges);
	}
	
	private SocialGraph populateGraph(int vertices, int edges)
	{
		User[] users = userGen.getUsers(vertices);
		for(User user : users)
		{
			graph.addVertex(user);
		}
		
		int range = users.length;
		
		for(int i = 0; i < edges; i++)
		{
			graph.addEdge(users[random.nextInt(range)],
					users[random.nextInt(range)]);
		}
		
		return graph;
	}
	

}
