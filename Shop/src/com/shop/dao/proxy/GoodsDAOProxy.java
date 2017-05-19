package com.shop.dao.proxy;

import java.sql.Connection;
import java.sql.SQLException;

import com.shop.dao.IGoodsDAO;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.dbc.DatabaseConnection;

public class GoodsDAOProxy implements IGoodsDAO{

	private DatabaseConnection dbc = null;
	private GoodsDaoImpl dao = null;
	public GoodsDAOProxy() throws SQLException, ClassNotFoundException
	{
		try
		{
			dbc = new DatabaseConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		dao = new GoodsDaoImpl(dbc.getConnection());
	}
	public boolean addToCart(int gID, int uID) throws SQLException
	{
		boolean isAdd = false;
		try
		{
			isAdd = dao.addToCart(gID, uID);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isAdd;
	}
}
