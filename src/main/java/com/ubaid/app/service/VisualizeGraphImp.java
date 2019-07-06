package com.ubaid.app.service;

import java.io.File;

import org.jgrapht.io.ExportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.dao.graph.SocialGraph;
import com.ubaid.app.decorator.exporter.GraphExporter;

@Component
public class VisualizeGraphImp implements VisualizeGraphService
{

	@Autowired
	GraphExporter exporter;
	
	@Override
	public void writeGraph(File file, SocialGraph graph) throws ExportException
	{
		exporter.exportGraph(graph, file);
	}

}
