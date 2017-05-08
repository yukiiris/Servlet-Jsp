package com.mvc.factory;

import com.mvc.dao.IUserDao;
import com.mvc.dao.proxy.UserDaoProxy;

public class DAOFactory {

	public static IUserDao getIUserDAOInstance()
	{
		return new UserDaoProxy();
	}
}
