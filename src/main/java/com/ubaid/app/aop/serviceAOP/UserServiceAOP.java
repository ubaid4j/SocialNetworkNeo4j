package com.ubaid.app.aop.serviceAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAOP extends ServiceAOP
{
	@Before("makeRandomlyUser()")
	public void logging(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		int vertices = (int) args[0];
		int edges = (int) args[1];		
		System.out.println("[INFO]: Creating graph of " + vertices + " vertices and " + edges + " edges");
	}
}
