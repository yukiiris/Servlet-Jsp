package com.shop.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.dao.IUserDAO;
import com.shop.vo.User;

public class UserDaoImpl implements IUserDAO{

	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public UserDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean doCreate(User user) throws Exception
	{
		boolean isCreate = false;
		try
		{
			String sql = "INSERT INTO user(id,name,password) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user.getID());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			
			if (pstm.executeUpdate() > 0)
			{
				isCreate = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isCreate;
	}

	public User findUser(User user) throws Exception
	{
		User finded = null;
		String sql = "SELECT id FROM user WHERE name=?,password=?";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		ResultSet rs = pstm.executeQuery();
		
		while (rs.next())
		{
			finded = new User();
			finded.setID(rs.getInt(1));
			finded.setName(rs.getString(2));
			finded.setPassword(rs.getString(3));
		}
		pstm.close();
		return finded;
	}

}
