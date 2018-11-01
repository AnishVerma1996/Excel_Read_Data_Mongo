package com.anish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anish.entity.Employee;
import com.anish.read.ReadEmp;
import com.anish.service.EmpService;

@RestController
public class EmpController 
{

@Autowired
private EmpService es;

@PostMapping("/Save")
public String  addEmp()
{
	 boolean b=es.saveEmp();
	 if(b)
		 return "SucessFully Read Data From Excel And Save in Database";
	 else
		 return "Failed Read Data From Excel And Save in Database";
}
@GetMapping("/getdata")
public List<Employee> getAll()
{
   	return es.getEmp();
}
}
