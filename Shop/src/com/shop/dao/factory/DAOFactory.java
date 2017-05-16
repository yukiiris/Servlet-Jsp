package com.shop.dao.factory;

import com.shop.dao.IUserDAO;
import com.shop.dao.proxy.UserDAOProxy;

public class DAOFactory {

	public static IUserDAO getIUserDAOInstance() throws Exception
	{
			return new UserDAOProxy();
	}
}
