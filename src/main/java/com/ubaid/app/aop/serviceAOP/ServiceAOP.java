package com.ubaid.app.aop.serviceAOP;

import org.aspectj.lang.annotation.Pointcut;

public abstract class ServiceAOP
{
	
	@Pointcut("execution(* com.ubaid.app.dao.GraphDAOV2.addAll(*)) throws RuntimeException")
	public void ingestUsersService() {}

	@Pointcut("execution(* com.ubaid.app.dao.GraphDAOV2.deleteAll(*)) throws RuntimeException")
	public void deleteAllService() {}
}
