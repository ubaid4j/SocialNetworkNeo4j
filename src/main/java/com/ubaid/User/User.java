package com.ubaid.User;

import org.springframework.stereotype.Component;

@Component
public class User
{
	private int age;
	private String email;
	private String name;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(int id, int age, String email, String name) {
		super();
		this.id = id;
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
}
