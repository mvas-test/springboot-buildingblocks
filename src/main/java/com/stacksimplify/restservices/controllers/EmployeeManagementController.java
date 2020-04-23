package com.stacksimplify.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.views.EmployeeViews;
import com.stacksimplify.restservices.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeManagementController {

	@Autowired
	private EmployeeService employeeService;

	//getAllEmployees - Normal View
	@GetMapping("/normalview")
	@JsonView(EmployeeViews.NormalView.class)
	public List<Employee> getAllNormalViewEmployees() {
		return employeeService.getAllEmployees();
	}

	//getAllEmployees - Manager View
	@GetMapping("/managerview")
	@JsonView(EmployeeViews.ManagerView.class)
	public List<Employee> getAllManagerViewEmployees() {
		return employeeService.getAllEmployees();
	}

	//getAllEmployees - HR View
	@GetMapping("/hrview")
	@JsonView(EmployeeViews.HRView.class)
	public List<Employee> getAllHRViewEmployees() {
		return employeeService.getAllEmployees();
	}

}
