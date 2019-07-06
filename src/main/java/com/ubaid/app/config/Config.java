package com.ubaid.app.config;

import java.util.Locale;
import java.util.Random;

import org.jgrapht.graph.DefaultEdge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ubaid.app"})
public class Config
{
	@Bean
	public Class<DefaultEdge> defaultEdge()
	{
		return DefaultEdge.class;
	}
	
	@Bean("locale")
	public Locale getPakLocale()
	{
		return new Locale("en-PAK");
	}
	
	@Bean("random")
	public Random random()
	{
		return new Random();
	}
	
	@Bean("currentDir")
	public String currentDir()
	{
		return System.getProperty("user.dir");
	}
}
