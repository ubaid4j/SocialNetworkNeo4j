package com.ubaid.app.config;

import java.util.Locale;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.ubaid.app"})
@EnableAspectJAutoProxy
@PropertySource("classpath:/Neo4JAuth.properties")
public class Config
{
	@Bean("locale")
	public Locale getPakLocale()
	{
		return new Locale("en-PAK");
	}
	
	@Bean("random")
	@Scope("prototype")
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
