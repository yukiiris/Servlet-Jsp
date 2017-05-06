package com.vo;

import java.sql.DriverManager;
import java.sql.*;

public class DatabaseConnection {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/dao";
	private static final String DBUSER = "user1";
	private static final String DBPASSWORD = "user1";
	private Connection conn = null;
	
	public DatabaseConnection() throws Exception
	{
		try
		{
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public void close() throws Exception
	{
		if (conn != null)
		{
			conn.close();
		}
	}
}
