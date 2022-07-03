package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Employee;
import com.model.EmployeerRemote;

@ManagedBean(name = "emp",eager = true)
public class EmployeeBean
{
	String uname;
	String name;
	String password;
	String response;
	
	@EJB(lookup = "java:global/vehicletrackingdemo2/EmployeeModel!com.model.EmployeerRemote")
	EmployeerRemote ER;
	
	public void callinsert()
	{
		try
		{
			Employee E =new Employee();
			E.setUname(uname);
			E.setName(name);
			E.setPassword(password);
			
			
			response = ER.insertData(E);
		}
		catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	
	public void find()
	{
		try
		{
			Employee E = ER.findData(uname);
			uname = E.getUname();
			password = E.getPassword();
			 
		}
		
		catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public EmployeerRemote getER() {
		return ER;
	}

	public void setER(EmployeerRemote eR) {
		ER = eR;
	}
	
	
	

}
