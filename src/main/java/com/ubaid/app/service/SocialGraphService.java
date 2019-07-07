package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.app.dao.GraphDAO;
import com.ubaid.app.dao.graph.SocialGraph;

@Service
public class SocialGraphService implements GraphService
{

	@Autowired
	GraphDAO graphDao;

	@Override
	public SocialGraph getDefaultGraph()
	{
		return graphDao.getDefaultGraph();
	}

	@Override
	public SocialGraph getCustomGraph(int vertices, int edges)
	{
		return graphDao.getCustomGraph(vertices, edges);
	}
	
}
