package com.hexaware.assetmangement.service;

import java.util.List;

import com.hexaware.assetmangement.dto.EmployeeDTO;
import com.hexaware.assetmangement.entities.Employee;

public interface IEmployeeService {
	
	public List<Employee> viewAllEmployees();
	public Employee addEmployee(EmployeeDTO emp);
	public Employee searchEmployeeById(int employeeId);
	public List<Employee> searchEmployeeByName(String employeeName);
	public Employee updateEmployeeInfo(Employee employee);
	public String removeEmployee(int employeeId);
}
