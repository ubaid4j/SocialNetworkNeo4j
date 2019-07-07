package com.ubaid.app.dao.visualizer;

public abstract class AbstractProcessBuilder
{
		
	public int executeCommand(String fileName) throws Exception
	{
		Runtime rt = Runtime.getRuntime();
		Process process = null;
		try
		{
			process = rt.exec(getCommand(fileName));	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		int exitValue = 0;
		try
		{
			exitValue = process.waitFor();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return exitValue;
	}
	
	public abstract String getCommand(String fileName);	
}
