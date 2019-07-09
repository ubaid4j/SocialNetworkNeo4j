package com.ubaid.app;

import java.io.File;
import java.util.Scanner;

import org.jgrapht.io.ExportException;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.config.Config;
import com.ubaid.app.dao.RandomlyRalatedUserDAO;
import com.ubaid.app.dao.graph.SocialGraph;
import com.ubaid.app.service.GraphService;
import com.ubaid.app.service.GraphServiceV2;
import com.ubaid.app.service.VisualizeGraphService;
import com.ubaid.entity.User;

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
		

		Session session = context.getBean("neo4jSession", Session.class);

		
		RandomlyRalatedUserDAO tmp1 = context.getBean("randomlyRelatedUserDAOImp", RandomlyRalatedUserDAO.class);
		
		User[] users = tmp1.makeRendomlyRelatedUsers(50, 50);
		
		GraphServiceV2 gS = context.getBean("graphServiceV2Imp", GraphServiceV2.class);
		
		
		try
		{
			gS.addAll(users);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
/**		
		Scanner input = new Scanner(System.in);
		int vertices = 0;
		int edges = 0;
		SocialGraph graph = null;

		
		try
		{
			System.out.println("Please Mention Vertices for Graph: ");
			vertices = input.nextInt();
			System.out.println("Please Mention Edges for Graph");
			edges = input.nextInt();
			System.out.println("Creating graph of " + vertices + " vertices and " + edges + " edges");
			graph = gService.getCustomGraph(vertices, edges);
		}
		catch(Exception exp)
		{
			System.out.println("Some Unknown Errors occured, Creating Default graph of 20 vertices and 20 edges");
			graph = gService.getDefaultGraph();
		}
		
		
		
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
*/		
		context.close();
	}
	
}
