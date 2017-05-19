package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shop.dao.IGoodsDAO;
import com.shop.dbc.DatabaseConnection;

public class GoodsDaoImpl implements IGoodsDAO{

	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public GoodsDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean addToCart(int gID, int uID) throws SQLException
	{
		boolean isAdd = false;
		try 
		{
			String sql = "INSERT INTO cart VALUES(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, gID);
			pstm.setInt(2, uID);
			if (pstm.executeUpdate() > 0)
			{
				isAdd = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isAdd;
	}
	
	public boolean buy(int gID, int uID) throws SQLException
	{
		boolean isBuy = false;
		try 
		{
			String sql = "";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isBuy;
	}
}
