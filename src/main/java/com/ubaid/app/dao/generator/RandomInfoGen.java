package com.ubaid.app.dao.generator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component 
class RandomInfoGen extends Faker
{
	
	@Autowired
	public RandomInfoGen(@Qualifier("locale") Locale locale)
	{
		super(locale);
	}	
}
