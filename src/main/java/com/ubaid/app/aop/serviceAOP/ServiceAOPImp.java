package com.ubaid.app.aop.serviceAOP;

import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubaid.app.service.LogLoopService;
import com.ubaid.entity.User;

@Aspect
@Component
public class ServiceAOPImp extends ServiceAOP
{

	
	private long start;
	private long end;
	
	@Autowired
	private LogLoopService logLoopService;
	
	@Before("ingestUsersDAO()")
	public void beforeEnteringToGraphDAOV2AddAllMethod(JoinPoint joinPoint)
	{	
		
		System.out.println("Adding Users In the database");
		System.out.println("Time Noted" + LocalDate.now());
		logLoopService.startMessageLoop("Please Wait--- It will not take a long");
		start = System.currentTimeMillis();

	}
	
	
	@After("ingestUsersDAO()")
	public void afterReturingFromGraphDAOV2AllAllMethod(JoinPoint joinPoint)
	{
		
		end = System.currentTimeMillis();

		Object[] args = joinPoint.getArgs();
		User[] users = (User[]) args[0];
		int size = users.length;

		logLoopService.stopMessageLoop();

		long duration = end - start;
		
		System.out.printf("\nThe total time spent for Ingesting "
				+ "%d Users in the database is %.6f seconds", size, (double) duration/ (double) 1000);
	}
}
