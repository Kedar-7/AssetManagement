package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;


@SpringBootTest
class EmployeeServiceImpTest {
	
	@Autowired
	private IEmployeeService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testViewAllEmployees() {
		List<Employee> employees = service.viewAllEmployees();
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
	}

	@Test
	void testAddEmployee() {
		EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(101);
        empDTO.setEmployeeName("Rahul Kumar");
        empDTO.setEmail("rahul.kumar@example.com");
        empDTO.setPassword("password1");
        empDTO.setGender("Male");
        empDTO.setContact("1234567890");
        empDTO.setAddress("Mumbai, Maharashtra ");
        //empDTO.setRole("Admin");

        Employee savedEmployee = service.addEmployee(empDTO);
        assertNotNull(savedEmployee);
	}

	@Test
	void testSearchEmployeeById() throws EmployeeNotFoundException {
		int employeeId = 101;
        Employee employee = service.searchEmployeeById(employeeId);
        assertNotNull(employee);
        assertEquals(employeeId, employee.getEmployeeId());
	}

	@Test
	void testSearchEmployeeByName() throws EmployeeNotFoundException {
		String employeeName = "Priya Sharma";
        Optional<Employee> employees = service.searchEmployeesByName(employeeName);
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(employeeName, employees.get().getEmployeeName());
	}

	@Test
	void testUpdateEmployeeInfo() {
		EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(101);
        empDTO.setEmployeeName("Rahul Kumar");
        empDTO.setEmail("rahul.kumar@example.com");
        empDTO.setPassword("newpassword");
        empDTO.setGender("Male");
        empDTO.setContact("1234567890");
        empDTO.setAddress("Mumbai, Maharashtra");
        empDTO.setRole("User");

        Employee updatedEmployee = service.updateEmployeeInfo(empDTO);
        assertNotNull(updatedEmployee);
        assertEquals(empDTO.getEmployeeName(), updatedEmployee.getEmployeeName());
	}

	@Test
	void testRemoveEmployee() {
		int employeeId = 1;
        String result = service.removeEmployee(employeeId);
        assertNotNull(result);
        assertEquals("Employee has been removed", result);
	}

}
