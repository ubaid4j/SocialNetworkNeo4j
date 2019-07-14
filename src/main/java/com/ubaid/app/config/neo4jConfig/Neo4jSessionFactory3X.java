package com.ubaid.app.config.neo4jConfig;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Neo4jSessionFactory3X
{
//	private final static Configuration configuration = new Configuration.Builder().uri("bolt://localhost:7687").credentials("neo4j", "password").build();
//	private final static SessionFactory sessionFactory = new SessionFactory(configuration, "com.ubaid.entity");
//
//	// prevent external instantiation
//	private Neo4jSessionFactory3X()
//	{
//	}
//
//	@Bean("neo4jSession")
//	public Session getNeo4jSession()
//	{
//	    return sessionFactory.openSession();
//	}
}
