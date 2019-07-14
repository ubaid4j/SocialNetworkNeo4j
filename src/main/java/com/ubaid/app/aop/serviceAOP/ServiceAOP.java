package com.ubaid.app.aop.serviceAOP;

import org.aspectj.lang.annotation.Pointcut;

public abstract class ServiceAOP
{
	
	@Pointcut("execution(* com.ubaid.app.dao.GraphDAOV2.addAll(*)) throws RuntimeException")
	protected void ingestUsersService() {}

	@Pointcut("execution(* com.ubaid.app.dao.GraphDAOV2.deleteAll(*)) throws RuntimeException")
	protected void deleteAllService() {}
	
	@Pointcut("execution(* com.ubaid.app.dao.RandomlyRalatedUserDAO.makeRendomlyRelatedUsers(int, int))")
	protected void makeRandomlyUser() {}
}
