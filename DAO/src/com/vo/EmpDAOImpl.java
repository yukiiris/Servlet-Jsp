package com.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl implements IEmpDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public EmpDAOImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean doCreate(Emp emp) throws Exception
	{
		boolean isCreated = false;
		String sql = "INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, emp.getEmpno());
		pstmt.setString(2, emp.getEname());
		pstmt.setString(3, emp.getJob());
		pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
		pstmt.setFloat(5, emp.getSal());
		if (pstmt.executeUpdate() > 0)
		{
			isCreated = true;
		}
		pstmt.close();
		return isCreated;
	}
	
	public List<Emp> findAll(String keyWord) throws Exception
	{
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,job,hiredate,sal FROM emp WHERE ename LIKE"
				+ " ? OR job LIKE ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWord + "%");
		pstmt.setString(2, "%" + keyWord + "%");
		ResultSet rs = pstmt.executeQuery();
		Emp emp = null;
		while (rs.next())
		{
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getFloat(5));
			all.add(emp);
		}
		pstmt.close();
		return all;
	}
	
	public Emp findByld(int empno) throws Exception
	{
		Emp emp = null;
		String sql = "SELECT empno,ename,job,hiredate,sal FROM emp WHERE empno=?";
		try
		{pstmt = conn.prepareStatement(sql);}catch (Exception e) {
			e.printStackTrace();
		}
		pstmt.setInt(1, empno);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setHiredate(rs.getDate(4));
			emp.setSal(rs.getFloat(5));
			System.out.println("5");
		}
		pstmt.close();
		System.out.println("4");
		return emp;
	}
	
}
