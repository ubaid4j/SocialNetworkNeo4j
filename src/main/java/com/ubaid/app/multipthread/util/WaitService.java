package com.ubaid.app.multipthread.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class WaitService implements Runnable
{
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public void run()
	{
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\n" + message + "\n");
			
			try
			{
				Thread.sleep(1500);
			}
			catch (InterruptedException e)
			{
				loop = false;
			}
		}
	}
}
