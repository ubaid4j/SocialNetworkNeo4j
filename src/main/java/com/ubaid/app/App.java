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
		
		//setting any logger disable
		LogManager.getLogManager().reset();
		Logger rootLogger = LogManager.getLogManager().getLogger("");
		rootLogger.setLevel(Level.SEVERE);
		for (Handler h : rootLogger.getHandlers())
		    h.setLevel(Level.SEVERE);
		
		//getting context
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		
		//random users
		RandomlyRalatedUserDAO tmp1
			= context.getBean("randomlyRelatedUserDAOImp", RandomlyRalatedUserDAO.class);
		
		//graph service [having addAll, deleteAll and query]
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
			
			User[] users = tmp1.makeRendomlyRelatedUsers(vertices, edges);
			gS.deleteAll();
			gS.addAll(users);
			
		}
		catch(Exception exp)
		{
			System.out.println("[ERROR]: Some Unknown Errors occured");
		}
		
		input.close();
		context.close();
		System.exit(0);
	}
	
}
