package com.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.dao.IUserDao;
import com.mvc.vo.User;

public class UserDaoImpl implements IUserDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public UserDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean findLogin(User user)throws Exception
	{
		boolean isFind = false;
		try
		{
			String sql = "SELECT name FROM user where userid=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				user.setName(rs.getString(1));
				isFind = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
			{
				try
				{
					ps.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return isFind;
	}
}
