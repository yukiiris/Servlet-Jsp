package com.shop.user;

public class User {

	private static int ID = 1;
	private String name;
	private String password;
	
	public User()
	{
		ID += 1;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
}
