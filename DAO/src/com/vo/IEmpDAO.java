package com.vo;

import java.util.List;

public interface IEmpDAO {

	public  boolean doCreate(Emp emp) throws Exception;
	public  List<Emp> findAll(String keyWord) throws Exception;
	public Emp findByld(int empno) throws Exception;
	
}
