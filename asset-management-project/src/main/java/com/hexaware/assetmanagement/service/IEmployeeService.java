package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;

public interface IEmployeeService {
	
	public List<Employee> viewAllEmployees();
	public Employee addEmployee(EmployeeDTO emp);
	public Employee searchEmployeeById(int employeeId);
	public List<Employee> searchEmployeeByName(String employeeName);
	public Employee updateEmployeeInfo(EmployeeDTO employee);
	public String removeEmployee(int employeeId);
}
