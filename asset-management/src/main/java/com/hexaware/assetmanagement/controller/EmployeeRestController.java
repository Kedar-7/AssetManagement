package com.hexaware.assetmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IEmployeeService;

@RestController
@RequestMapping("/asset")

public class EmployeeRestController {

	@Autowired
	IEmployeeService service;

	@PostMapping("/addNewEmployee")
	public Employee addNewAsset(@RequestBody EmployeeDTO employeeDTO) {

		return service.addEmployee(employeeDTO);

	}

	@GetMapping("/displayAllEmployees")
	public List<Employee> diplayAllAssets() {
		return service.viewAllEmployees();

	}

	@GetMapping("/displayEmployeeById/{employeeId}")
	public Employee displayEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {

		return service.searchEmployeeById(employeeId);

	}

	@GetMapping("displayEmployeesByName/{employeeName}")
	public List<Employee> displayEmployeeByName(@PathVariable String employeeName) throws EmployeeNotFoundException{
		return service.searchEmployeesByName(employeeName);
	}

}
