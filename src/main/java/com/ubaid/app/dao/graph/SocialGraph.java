package com.ubaid.app.dao.graph;


import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.stereotype.Component;

import com.ubaid.entity.User;

@Component
public class SocialGraph extends DefaultDirectedGraph<User, DefaultEdge>
{
	private static final long serialVersionUID = 7581251236225714333L;
	
	public SocialGraph(Class<? extends DefaultEdge> edgeClass)
	{
		super(edgeClass);
	}
}
