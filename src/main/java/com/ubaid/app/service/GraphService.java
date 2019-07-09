package com.ubaid.app.service;

import com.ubaid.app.dao.graph.SocialGraph;

/**
 * 
 * This is deprecated, don't use it
 * 
 * @author UbaidurRehman
 *
 */
public interface GraphService
{
	public SocialGraph getDefaultGraph();
	public SocialGraph getCustomGraph(int vertices, int edges);
}
