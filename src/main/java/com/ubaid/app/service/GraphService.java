package com.ubaid.app.service;

import com.ubaid.app.dao.graph.SocialGraph;

public interface GraphService
{
	public SocialGraph getDefaultGraph();
	public SocialGraph getCustomGraph(int vertices, int edges);
}
