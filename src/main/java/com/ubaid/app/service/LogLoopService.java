package com.ubaid.app.service;

/**
 * It has two methods, one will start a loop message 
 * and second one will eliminate it.
 * Not thread safe
 * @author UbaidurRehman
 *
 */
public interface LogLoopService
{
	public void startMessageLoop(String message);
	public void stopMessageLoop();
}
