package com.vo;

public class DAOFactory {

	public static IEmpDAO getIEmpDaoInstance() throws Exception
	{
		return new IEmpDAOProxy();
	}
}
