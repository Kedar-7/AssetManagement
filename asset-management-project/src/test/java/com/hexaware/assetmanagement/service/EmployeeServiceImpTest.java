package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;


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
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("John Doe");
        empDTO.setEmail("john@example.com");
        empDTO.setPassword("password");
        empDTO.setGender("Male");
        empDTO.setContact("1234567890");
        empDTO.setAddress("123, Main Street");
        empDTO.setRole("Employee");

        Employee savedEmployee = service.addEmployee(empDTO);
        assertNotNull(savedEmployee);
	}

	@Test
	void testSearchEmployeeById() {
		int employeeId = 101;
        Employee employee = service.searchEmployeeById(employeeId);
        assertNotNull(employee);
        assertEquals(employeeId, employee.getEmployeeId());
	}

	@Test
	void testSearchEmployeeByName() {
		String employeeName = "Rahul Kumar";
        List<Employee> employees = service.searchEmployeeByName(employeeName);
        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(employeeName, employees.get(0).getEmployeeName());
	}

	@Test
	void testUpdateEmployeeInfo() {
		EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("John Updated");
        empDTO.setEmail("john@example.com");
        empDTO.setPassword("password");
        empDTO.setGender("Male");
        empDTO.setContact("1234567890");
        empDTO.setAddress("123, Main Street");
        empDTO.setRole("Employee");

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
