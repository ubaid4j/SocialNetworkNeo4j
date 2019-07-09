package com.ubaid.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ubaid.app.dao.LogLoopDAO;

@Service
public class LogLoopServiceImp implements LogLoopService
{

	@Autowired
	@Qualifier("logLoopDAOImp")
	LogLoopDAO logLoopDAO;
	
	@Override
	public void startMessageLoop(String message)
	{
		logLoopDAO.startMessageLoop(message);
	}

	@Override
	public void stopMessageLoop()
	{
		logLoopDAO.stopMessageLoop();
	}

}
