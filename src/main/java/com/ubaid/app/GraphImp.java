package com.ubaid.app;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;

import com.ubaid.app.config.neo4jConfig.Neo4jSessionFactory;

/**
 * 
 * @author UbaidurRehman
 *
 * Step: 1. First create the Neo4JSessionFactory
 *
 *
 *
 *
 *
 */



public class GraphImp
{

	
	public static void main(String [] args)
	{
		GraphImp graphImp = new GraphImp();
		graphImp.app();
	}

	
	public void app()
	{

		
		Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();		
		
//		UserT1 u1 = new UserT1(20, "urehman.bese16seecs@seecs.edu.pk", "Ubaid");
//		UserT1 u2 = new UserT1(21, "kkhan.bese16seecs@seecs.edu.pk", "Kashif");
//		UserT1 u3 = new UserT1(22, "mfarooq.bese16seecs@seecs.edu.pk", "Ahsan Farooq");
//		u2.getFollowings().add(u1);
//		u3.getFollowings().add(u1);
//		u1.getFollowings().add(u3);
//		u1.getFollowings().add(u2);
//		u2.getFollowings().add(u3);
//		u3.getFollowings().add(u2);

		Transaction transaction = session.beginTransaction();
		
//		session.save(u1);
//		session.save(u2);
//		session.save(u3);
		
		transaction.commit();

//		session.save(u1, 2000);
//		session.save(u2, 2000);
//		session.save(u3, 2000);
			
	}
	
}

