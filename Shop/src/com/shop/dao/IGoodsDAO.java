package com.shop.dao;

import java.sql.SQLException;

public interface IGoodsDAO {

	public boolean addToCart(int gID, int uID) throws SQLException;
	//public boolean buy(int gID, int uID) throws SQLException;
}
