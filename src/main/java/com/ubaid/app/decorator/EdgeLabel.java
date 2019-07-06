package com.ubaid.app.decorator;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.springframework.stereotype.Component;


@Component
public class EdgeLabel implements ComponentNameProvider<DefaultEdge>
{

	@Override
	public String getName(DefaultEdge component)
	{
		return "Follow";
	}
}
