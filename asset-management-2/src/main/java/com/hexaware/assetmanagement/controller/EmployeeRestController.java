package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IEmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @PostMapping("/addNewEmployee")
    public Employee addNewAsset(@RequestBody EmployeeDTO employeeDTO) {
        logger.info("Adding new employee: {}", employeeDTO);
        return service.addEmployee(employeeDTO);
    }

    @GetMapping("/displayAllEmployees")
    public List<Employee> diplayAllEmployees() {
        logger.info("Displaying all employees");
        return service.viewAllEmployees();
    }
    
    @PutMapping("/update")
    public Employee updateEmployeeInfo(@RequestBody EmployeeDTO employee) {
        logger.info("Updating employee info: {}", employee);
        return service.updateEmployeeInfo(employee);
    }

    @DeleteMapping("/delete")
    public String removeEmployee(@PathVariable int employeeId) {
        logger.info("Removing employee with ID: {}", employeeId);
        service.removeEmployee(employeeId);
        return "Record Deleted";
    }
    
    @GetMapping("/displayEmployeeById/{employeeId}")
    public Employee displayEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        logger.info("Displaying employee with ID: {}", employeeId);
        return service.searchEmployeeById(employeeId);
    }

    @GetMapping("displayEmployeesByName/{employeeName}")
    public List<Employee> displayEmployeeByName(@PathVariable String employeeName) throws EmployeeNotFoundException {
        logger.info("Displaying employee with name: {}", employeeName);
        return service.searchEmployeesByName(employeeName);
    }
}