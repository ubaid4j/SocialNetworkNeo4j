package com.ubaid.app.service;

import java.io.File;

import org.jgrapht.io.ExportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.app.dao.graph.SocialGraph;
import com.ubaid.app.dao.visualizer.WindowsProcessBuilder;
import com.ubaid.app.decorator.exporter.GraphExporter;

@Service
public class VisualizeGraphImp implements VisualizeGraphService
{

	@Autowired
	GraphExporter exporter;

	@Autowired
	WindowsProcessBuilder builder;
	
	@Override
	public void writeGraph(File file, SocialGraph graph) throws ExportException
	{
		exporter.exportGraph(graph, file);
		System.out.println("Graph has been written in " + file.getAbsolutePath());

	}

	@Override
	public int visualize(File file, SocialGraph graph) throws Exception
	{
		writeGraph(file, graph);
		int exitValue = builder.executeCommand(file.getName());
		
		if(exitValue == 0)
		{
			System.out.println(file.getAbsolutePath() + ".png" + " has been successfully created");
		}
		else
		{
			System.out.println(file.getName() + ".png is not created due to following reasons");
			System.out.println("Install GraphViz and set path");
		}
		
		return exitValue;
	}

}
