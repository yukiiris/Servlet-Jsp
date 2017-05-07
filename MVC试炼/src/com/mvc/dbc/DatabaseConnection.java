package com.mvc.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static final String DBDRIBER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mvc";
	private static final String DBUSER = "user1";
	private static final String DBPASSWORD = "user1";
	private Connection conn = null;
	
	public DatabaseConnection() throws Exception
	{
		try 
		{
			Class.forName(DBDRIBER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public void close()throws Exception
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}		
	}
}
