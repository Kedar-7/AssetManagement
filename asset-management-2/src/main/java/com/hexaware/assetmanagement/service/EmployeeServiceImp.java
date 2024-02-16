package com.hexaware.assetmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.repository.EmployeeRepository;



@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private EmployeeRepository repo;

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Override
    public List<Employee> viewAllEmployees() {
        logger.info("Fetching all employees from the database");
        return repo.findAll();
    }

    @Override
    public Employee addEmployee(EmployeeDTO emp) {
        logger.info("Adding employee: {}", emp);
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
    public Employee searchEmployeeById(int employeeId) throws EmployeeNotFoundException {
        logger.info("Searching for employee with ID: {}", employeeId);
        Employee emp = repo.findById(employeeId).orElse(null);
        if (emp != null) {
            return emp;
        } else {
            logger.warn("Employee with ID {} not found", employeeId);
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
        }
    }

    @Override
    public Employee updateEmployeeInfo(EmployeeDTO employee) {
        logger.info("Updating employee information: {}", employee);
        Employee updatedEmployee = new Employee();
        updatedEmployee.setEmployeeId(employee.getEmployeeId());
        updatedEmployee.setEmployeeName(employee.getEmployeeName());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setPassword(employee.getPassword());
        updatedEmployee.setGender(employee.getGender());
        updatedEmployee.setContact(employee.getContact());
        updatedEmployee.setAddress(employee.getAddress());
        updatedEmployee.setRole(employee.getRole());
        return repo.save(updatedEmployee);
    }

    @Override
    public String removeEmployee(int employeeId) {
        logger.info("Removing employee with ID: {}", employeeId);
        repo.deleteById(employeeId);
        return "Employee has been removed";
    }

    @Override
    public List<Employee> searchEmployeesByName(String employeeName) throws EmployeeNotFoundException {
        logger.info("Searching employees by name: {}", employeeName);
        List<Employee> employees = repo.employeesByName(employeeName);

        if (!employees.isEmpty()) {
            return employees;
        } else {
            logger.warn("No employees found with name: {}", employeeName);
            throw new EmployeeNotFoundException("Employee with name " + employeeName + " not found.");
        }
    }
}
