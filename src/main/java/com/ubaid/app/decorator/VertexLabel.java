package com.ubaid.app.decorator;

import org.jgrapht.io.ComponentNameProvider;
import org.springframework.stereotype.Component;

import com.ubaid.user.User;

@Component
public class VertexLabel implements ComponentNameProvider<User>
{

	@Override
	public String getName(User user)
	{
		return user.toString();
	}

}
