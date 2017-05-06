package com.vo;

import java.util.List;

public class IEmpDAOProxy implements IEmpDAO{

	private DatabaseConnection dbc = null;
	private IEmpDAO dao = null;
	
	public IEmpDAOProxy() throws Exception
	{
		dbc = new DatabaseConnection();
		dao = new EmpDAOImpl(dbc.getConnection());
	}
	
	public boolean doCreate(Emp emp) throws Exception
	{
		System.out.println("2");
		boolean isCreated = false;
		try
		{
			if (dao.findByld(emp.getEmpno()) == null)
			{
				System.out.println("3");
				isCreated = dao.doCreate(emp);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		finally
		{
			dbc.close();
		}
		return isCreated;
	}
	
	public List<Emp> findAll(String keyWord) throws Exception
	{
		List<Emp> all = null;
		try
		{
			all = dao.findAll(keyWord);
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			dbc.close();
		}
		return all;
	}
	
	public Emp findByld(int empno) throws Exception
	{
		Emp emp = null;
		try
		{
			emp = dao.findByld(empno);
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			dbc.close();
		}
		return emp;
	}
}
