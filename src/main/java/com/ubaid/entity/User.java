package com.ubaid.entity;

import java.util.LinkedList;
import java.util.List;

//import org.neo4j.ogm.annotation.GeneratedValue;
//import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.stereotype.Component;

@Component
@NodeEntity
public class User
{
	private int age;
	private String email;
	private String name;

//	@Id
//	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	@Relationship(type = "follow", direction = "OUTGOING")
	private List<User> followings = new LinkedList<User>();

	
	public void addFollower(User user)
	{
		followings.add(user);
	}
	
	public User(int age, String email, String name) {
		super();
		this.age = age;
		this.email = email;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
