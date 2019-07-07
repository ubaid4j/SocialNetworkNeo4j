package com.ubaid.app.dao.visualizer;

import org.springframework.stereotype.Repository;

@Repository
public class WindowsProcessBuilder extends AbstractProcessBuilder
{
	@Override
	public String getCommand(String fileName)
	{
		return "dot -Tpng " + fileName + " -O";
	}
}
