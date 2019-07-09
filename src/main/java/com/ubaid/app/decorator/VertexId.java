package com.ubaid.app.decorator;

import org.jgrapht.io.ComponentNameProvider;
import org.springframework.stereotype.Component;

import com.ubaid.User.User;

@Component
public class VertexId implements ComponentNameProvider<User>
{
	@Override
	public String getName(User user)
	{
		return user.getName().replace(" ", "_").replace(".", "_");
	}
}
