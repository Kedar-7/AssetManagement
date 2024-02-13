package com.hexaware.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;


public interface IEmployeeService {
	
	public List<Employee> viewAllEmployees();
	public Employee addEmployee(EmployeeDTO emp);
	public Employee searchEmployeeById(int employeeId) throws EmployeeNotFoundException;

	public Employee updateEmployeeInfo(EmployeeDTO employeeDTO);

	public String removeEmployee(int employeeId);
	
	public Optional<Employee> searchEmployeesByName(String employeeName) throws EmployeeNotFoundException;
}
