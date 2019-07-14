package com.ubaid.app;

import org.neo4j.ogm.service.Components;

public class GraphImp
{
	public static void main(String args)
	{
		double configuration = Components.neo4jVersion();
		System.out.println(configuration);
	}
}

