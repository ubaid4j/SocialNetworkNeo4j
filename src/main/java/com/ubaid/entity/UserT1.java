package com.ubaid.entity;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class UserT1
{
	@Id
	@GeneratedValue
	private Long id;
	
	private int age;
	private String email;
	private String name;
	
	
	
	/**
	 * @param age
	 * @param email
	 * @param name
	 */
	public UserT1(int age, String email, String name) {
		super();
		this.age = age;
		this.email = email;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "UserT1 [id=" + id + ", name=" + name + "]";
	}

	@Relationship(type = "follow", direction = "INCOMING")
	private List<UserT1> followers;

	@Relationship(type = "follow", direction = "OUTGOING")
	private List<UserT1> followings;
	
}
