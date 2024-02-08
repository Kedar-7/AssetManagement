package com.hexaware.assetmangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmangement.dto.EmployeeDTO;
import com.hexaware.assetmangement.entities.Employee;
import com.hexaware.assetmangement.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);
	
	@Override
	public List<Employee> viewAllEmployees() {
		
		return repo.findAll();
	}

	@Override
	public Employee addEmployee(EmployeeDTO emp) {
		logger.info(emp+" is Added from Add Service");

		Employee employee = new Employee();
		employee.setEmployeeId(emp.getEmployeeId());
		employee.setEmployeeName(emp.getEmployeeName());
		employee.setEmail(emp.getEmail());
		employee.setPassword(emp.getPassword());
		employee.setGender(emp.getGender());
		employee.setContact(emp.getContact());
		employee.setAddress(emp.getAddress());
		employee.setRole(emp.getRole());
		return repo.save(employee);
	}

	@Override
	public Employee searchEmployeeById(int employeeId) {
		return repo.findById(employeeId).orElse(null);
	}

	@Override
	public List<Employee> searchEmployeeByName(String employeeName) {
		return repo.findByEmployeeName(employeeName);
	}

	@Override
	public Employee updateEmployeeInfo(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public String removeEmployee(int employeeId) {
		 repo.deleteById(employeeId);
		 return "Employee has been removed";
	}

}
