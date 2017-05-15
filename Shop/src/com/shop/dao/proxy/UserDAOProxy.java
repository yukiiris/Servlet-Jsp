package com.shop.dao.proxy;

import com.shop.dao.IUserDAO;
import com.shop.dbc.DatabaseConnection;
import com.shop.vo.User;

public class UserDAOProxy implements IUserDAO{

	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;
	
	public UserDAOProxy() throws Exception
	{
		dbc = new DatabaseConnection();
	}
	
	public boolean doCreate(User user) throws Exception
	{
		try
		{
			
		}
	}
}
