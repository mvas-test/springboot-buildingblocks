package com.stacksimplify.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//getAllEmployees
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
