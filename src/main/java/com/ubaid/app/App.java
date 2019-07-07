package com.ubaid.app;

import java.io.File;

import org.jgrapht.io.ExportException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.config.Config;
import com.ubaid.app.dao.graph.SocialGraph;
import com.ubaid.app.service.GraphService;
import com.ubaid.app.service.VisualizeGraphService;

public class App
{
	public static void main(String [] args)
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		GraphService gService =
				context.getBean("socialGraphService", GraphService.class);
		
		VisualizeGraphService vgs = 
				context.getBean("visualizeGraphImp", VisualizeGraphService.class);
		
		String curDir = 
				context.getBean("currentDir", String.class);
		
		SocialGraph graph = gService.getDefaultGraph();
		
		File file = new File(curDir + "/graph.dot");
		
		try
		{
			vgs.visualize(file, graph);
		}
		catch (ExportException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		assert(graph != null);
		
		context.close();
	}
	
}
