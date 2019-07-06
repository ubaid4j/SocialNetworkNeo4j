package com.ubaid.app.dao;

import com.ubaid.app.dao.graph.SocialGraph;

public interface GraphDAO
{
	public SocialGraph getDefaultGraph();
	public SocialGraph getCustomGraph(int vertix, int edges);
}
