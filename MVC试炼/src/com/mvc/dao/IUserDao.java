package com.mvc.dao;

import com.mvc.vo.User;

public interface IUserDao {

	public boolean findLogin(User user) throws Exception;
}
