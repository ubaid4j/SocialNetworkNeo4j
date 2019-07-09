package com.ubaid.app.dao.generator;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.github.javafaker.Name;
import com.ubaid.entity.User;

@Component
public class UserGenerator
{

	String[] batch = {"bese16", "bscs16", "bee16","bese18", "bscs18", "bee18","bese17", "bscs17", "bee17"};
	
	@Autowired
	private RandomInfoGen fakeInfoGen;
	
	@Autowired
	@Qualifier("random")
	private Random random;
	
	public User[] generateUsers(final int LIMIT)
	{
		User[] users = new User[LIMIT];
		for(int i = 0; i < LIMIT; i++)
		{
			users[i] = getRandomUser(i);
		}		
		return users;
	}
	
	private User getRandomUser(int id)
	{
		Name nameObj = fakeInfoGen.name();
		String firstName = nameObj.firstName();
		String lastName = nameObj.lastName();
		String name = firstName + " " + lastName; 
		String email = String.format("%s%s.%sseecs@seecs.edu.pk", lastName, firstName, batch[random.nextInt(9)]);
		int age = random.nextInt(6) + 18;
		return new User(age, email, name);
	}

}
