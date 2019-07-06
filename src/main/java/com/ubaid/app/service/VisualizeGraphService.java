package com.ubaid.app.service;

import java.io.File;

import org.jgrapht.io.ExportException;

import com.ubaid.app.dao.graph.SocialGraph;

public interface VisualizeGraphService
{
	public void writeGraph(File file, SocialGraph graph) throws ExportException;
}
