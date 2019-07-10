package com.ubaid.app.dao;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubaid.entity.User;

@Repository
public class SocialGraphDAOV2 implements GraphDAOV2
{

	@Autowired
	Session session;
	
	@Override
	public void addAll(User[] users) throws RuntimeException
	{
		Transaction transaction = session.beginTransaction();
		for(User user : users)
		{
			session.save(user);
		}
		transaction.commit();
		transaction.close();
	}

	@Override
	public void deleteAll() throws RuntimeException
	{
		session.deleteAll(User.class);
	}

}
