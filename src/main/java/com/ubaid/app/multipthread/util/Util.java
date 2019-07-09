package com.ubaid.app.multipthread.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Util
{
	@Bean("singleThreadPool")
	public ExecutorService getExecutorService()
	{
		return Executors.newFixedThreadPool(1);
	}
}
