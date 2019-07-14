package com.ubaid.app.config.neo4jConfig;


import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.service.Components;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Neo4jSessionFactory2X
{
	double configuration = Components.neo4jVersion();
}
