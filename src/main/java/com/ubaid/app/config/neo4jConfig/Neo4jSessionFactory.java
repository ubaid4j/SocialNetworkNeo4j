package com.ubaid.app.config.neo4jConfig;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Neo4jSessionFactory
{
		private final static Configuration configuration = new Configuration.Builder().uri("bolt://localhost:7687").credentials("neo4j", "password").build();
	    private final static SessionFactory sessionFactory = new SessionFactory(configuration, "com.ubaid.entity");
	    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();
	    
	    public static Neo4jSessionFactory getInstance() {
	        return factory;
	    }

	    // prevent external instantiation
	    private Neo4jSessionFactory() {
	    }

	    @Bean("neo4jSession")
	    public Session getNeo4jSession() {
	        return sessionFactory.openSession();
	    }
}
