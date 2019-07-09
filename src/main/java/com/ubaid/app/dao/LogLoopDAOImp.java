package com.ubaid.app.dao;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ubaid.app.multipthread.util.WaitService;

@Repository
public class LogLoopDAOImp implements LogLoopDAO
{

	@Autowired
	@Qualifier("singleThreadPool")
	ExecutorService singleThreadPool;
	
	@Autowired
	WaitService waitService;
	
	@Override
	public void startMessageLoop(String message)
	{
		waitService.setMessage(message);
		singleThreadPool.execute(waitService);
	}

	@Override
	public void stopMessageLoop()
	{
		singleThreadPool.shutdownNow();
	}

}
