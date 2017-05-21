package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.IGoodsDAO;
import com.shop.dbc.DatabaseConnection;
import com.shop.vo.Goods;

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

	public List<Goods> findAll() throws SQLException
	{
		List<Goods> list = new ArrayList<Goods>();
		try
		{
			String sql = "SELECT * FROM goods";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			{
				Goods goods = new Goods();
				goods.setPrice(rs.getFloat(2));
				goods.setIntroduction(rs.getString(3));
				goods.setName(rs.getString(4));
				list.add(goods);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		 return list;
	}

}
