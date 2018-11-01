package com.anish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.entity.Employee;
import com.anish.read.ReadEmp;
import com.anish.repository.EmpRepository;

@Service
public class EmpService
{
@Autowired
private EmpRepository er;
public List<Employee> getEmp()
{
	List<Employee> list=er.findAll();
	return list;
}
public boolean saveEmp()
{
	boolean b=false;
	ReadEmp re=new ReadEmp();
	List<Employee> list=null;
	try
	{
	 list=re.getDataFromExcel();
	}
	catch(Exception e)
	{
		
	}
	for (Employee employee : list) 
	{
		er.save(employee);
		b=true;
	}
	return b;
}
}
