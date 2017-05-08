package com.mvc.dao.proxy;

import com.mvc.dao.IUserDao;
import com.mvc.dao.impl.UserDaoImpl;
import com.mvc.dbc.DatabaseConnection;
import com.mvc.vo.User;

public class UserDaoProxy implements IUserDao{

	private DatabaseConnection dbc = null;
	private IUserDao dao = null;
	
	public UserDaoProxy()
	{
		try
		{
			dbc = new DatabaseConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		dao = new UserDaoImpl(dbc.getConnection());
	}
	
	public boolean findLogin(User user) throws Exception
	{
		boolean isFind = false;
		try
		{
			isFind = dao.findLogin(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.close();
		}
		return isFind;
	}
}
