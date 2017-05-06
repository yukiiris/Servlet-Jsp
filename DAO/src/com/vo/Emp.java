package com.vo;

import java.util.Date;

public class Emp {

	private int empno;
	private String ename;
	private String job;
	private Date date;
	private float sal;
	
	public int getEmpno()
	{
		return empno;
	}
	
	public void setEmpno(int empno)
	{
		this.empno = empno;
	}
	
	public String getEname()
	{
		return ename;
	}
	
	public void setEname(String ename)
	{
		this.ename = ename;
	}
	
	public String getJob()
	{
		return job;
	}
	
	public void setJob(String job)
	{
		this.job = job;
	}
	
	public Date getHiredate()
	{
		return date;
	}
	
	public void setHiredate(Date date)
	{
		this.date = date;
	}
	
	public float getSal()
	{
		return sal;
	}
	
	public void setSal(float sal)
	{
		this.sal = sal;
	}
}
