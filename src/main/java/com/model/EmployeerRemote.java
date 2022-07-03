package com.model;

import javax.ejb.Remote;

import com.entity.Employee;

@Remote
public interface EmployeerRemote 
{
	public String insertData(Employee E)throws Exception;
	public Employee findData(String uname)throws Exception;

}
