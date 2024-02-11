package com.hexaware.assetmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.hexaware.assetmanagement.dto.AuthRequest;
import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IEmployeeService;
import com.hexaware.assetmanagement.service.JwtService;

@RestController
@RequestMapping("/employee")

public class EmployeeRestController {

	@Autowired
	IEmployeeService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/addNewEmployee")
	public Employee addNewAsset(@RequestBody EmployeeDTO employeeDTO) {

		return service.addEmployee(employeeDTO);

	}

	@GetMapping("/displayAllEmployees")
	@PreAuthorize("hasAuthority('Admin')")
	public List<Employee> diplayAllAssets() {
		return service.viewAllEmployees();

	}

	@GetMapping("/displayEmployeeById/{employeeId}")
	public Employee displayEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {

		return service.searchEmployeeById(employeeId);

	}

	@GetMapping("displayEmployeesByName/{employeeName}")
	@PreAuthorize("hasAuthority('Admin')")
	public Optional<Employee> displayEmployeeByName(@PathVariable String employeeName)
			throws EmployeeNotFoundException {
		return service.searchEmployeesByName(employeeName);
	}

	@PutMapping("/updateEmployeeDetail")
	@PreAuthorize("hasAuthority('Admin')")
	public Employee updateEmployeeInfo(@RequestBody EmployeeDTO employeeDTO) {

		return service.updateEmployeeInfo(employeeDTO);

	}

	
	@DeleteMapping("/removeEmployeeDetail/{employeeId}")
	@PreAuthorize("hasAuthority('Admin')")

	public String removeEmployee(@PathVariable int employeeId) {
		return service.removeEmployee(employeeId);
	}

	@PostMapping("/login/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getemail(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getemail());
		} else {
			throw new UsernameNotFoundException("UserName or Password is invalid");
		}
		return token;
	}

}
