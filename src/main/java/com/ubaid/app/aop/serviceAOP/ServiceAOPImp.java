package com.ubaid.app.aop.serviceAOP;

import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("ingestUsersService()")
	public Object igestTimeLogging(ProceedingJoinPoint joinPoint)
	{
		Object result = null;
		
		System.out.println("[INFO]: Adding Users In the database");
		System.out.println("[INFO]: Starting Time-->" + getCurrentTime());
		logLoopService.startMessageLoop("Please Wait--- It will not take a long");
		Object[] args = joinPoint.getArgs();
		User[] users = (User[]) args[0];
	
		int size = users.length;

		start = System.currentTimeMillis();
		try
		{
			result = joinPoint.proceed();
			end = System.currentTimeMillis();
			logLoopService.stopMessageLoop();
			long duration = end - start;
			System.out.println("[INFO]: Ending Time-->" + getCurrentTime());			
			System.out.printf("[INFO]: The total time spent for Ingesting "
					+ "%d Users in the database is %.6f seconds\n", size, (double) duration/ (double) 1000);
		}
		catch(Throwable exp)
		{
			exp.printStackTrace();
			System.out.println("[Error]: " + exp.getMessage());
			System.out.println("[Error]: " + exp.getCause());

			logLoopService.stopMessageLoop();
			result = exp.getMessage();
		}
		
		return result;
	}

	private Timestamp getCurrentTime()
	{
		Date date = new Date();
		long time = date.getTime();
		return new Timestamp(time);
	}
	
/**		
	@Before("ingestUsersService()")
	public void beforeEnteringToGraphDAOV2AddAllMethod(JoinPoint joinPoint)
	{	
		System.out.println("Adding Users In the database");
		System.out.println("Time Noted" + LocalDate.now());
		logLoopService.startMessageLoop("Please Wait--- It will not take a long");
		start = System.currentTimeMillis();
	}
	
	@After("ingestUsersService()")
	public void afterReturingFromGraphDAOV2AllAllMethod(JoinPoint joinPoint)
	{
		
		end = System.currentTimeMillis();

		Object[] args = joinPoint.getArgs();
		User[] users = (User[]) args[0];
		int size = users.length;

		logLoopService.stopMessageLoop();

		long duration = end - start;
		
		System.out.printf("\n[Info]\tThe total time spent for Ingesting "
				+ "%d Users in the database is %.6f seconds\n", size, (double) duration/ (double) 1000);
	}
*/	
	@Before("deleteAllService()")
	public void beforeDeleting()
	{
		System.out.println("[Info]: Deleting all nodes in the graph");
	}
	
	@After("deleteAllService()")
	public void afterDeleteing()
	{
		System.out.println("[Info]: All nodes in the database deleted");
	}
}
