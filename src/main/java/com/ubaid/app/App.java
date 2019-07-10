package com.ubaid.app;

import java.util.Scanner;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.config.Config;
import com.ubaid.app.dao.RandomlyRalatedUserDAO;
import com.ubaid.app.service.GraphServiceV2;
import com.ubaid.entity.User;

public class App
{
	public static void main(String [] args)
	{
		

		LogManager.getLogManager().reset();
		Logger rootLogger = LogManager.getLogManager().getLogger("");
		rootLogger.setLevel(Level.SEVERE);
		for (Handler h : rootLogger.getHandlers())
		    h.setLevel(Level.SEVERE);
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
			
		RandomlyRalatedUserDAO tmp1
			= context.getBean("randomlyRelatedUserDAOImp", RandomlyRalatedUserDAO.class);
		
		

		
		
		GraphServiceV2 gS = context.getBean("graphServiceV2Imp", GraphServiceV2.class);
		
		
		
	
		Scanner input = new Scanner(System.in);
		int vertices = 0;
		int edges = 0;

		
		try
		{
			System.out.println("Please Mention Vertices for Graph: ");
			vertices = input.nextInt();
			System.out.println("Please Mention Edges for Graph");
			edges = input.nextInt();
			System.out.println("Creating graph of " + vertices + " vertices and " + edges + " edges");
			
			User[] users = tmp1.makeRendomlyRelatedUsers(vertices, edges);
			gS.deleteAll();
			gS.addAll(users);
			
		}
		catch(Exception exp)
		{
			System.out.println("Some Unknown Errors occured");
		}
		
		input.close();
		context.close();
	}
	
}
