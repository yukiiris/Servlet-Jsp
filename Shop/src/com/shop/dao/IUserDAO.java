package com.shop.dao;

import com.shop.vo.User;

public interface IUserDAO {

	public boolean doCreate(User user) throws Exception;
	public User findUser(User user) throws Exception; 
}
