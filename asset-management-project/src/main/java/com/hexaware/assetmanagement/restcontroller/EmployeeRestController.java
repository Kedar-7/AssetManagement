package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hexaware.assetmanagement.dto.EmployeeDTO;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IEmployeeService;




@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/getall")
    public ResponseEntity<Object> viewAllEmployees() {
        try {
            List<Employee> employees = service.viewAllEmployees();
            logger.info("Retrieved all employees");
            return ResponseEntity.ok().body(employees);
        } catch (Exception e) {
            logger.error("Error retrieving all employees: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving all employees");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO emp) {
        try {
            logger.info("Adding new employee");
            Employee employee = service.addEmployee(emp);
            logger.info("Employee added successfully: {}", employee);
            return ResponseEntity.ok().body(employee);
        } catch (Exception e) {
            logger.error("Error adding employee: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding employee");
        }
    }

    @GetMapping("/getbyid/{employeeId}")
    public ResponseEntity<Object> searchEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        try {
            Employee emp = service.searchEmployeeById(employeeId);
            logger.info("Retrieved employee by ID: {}", employeeId);
            return ResponseEntity.ok().body(emp);
        } catch (Exception e) {
            logger.error("Error searching employee by ID: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching employee by ID");
        }
    }

    @GetMapping("/getbyname/{employeeName}")
    public ResponseEntity<Object> searchEmployeeByName(@PathVariable String employeeName) {
        try {
            List<Employee> employees = service.searchEmployeeByName(employeeName);
            logger.info("Retrieved employees by name: {}", employeeName);
            return ResponseEntity.ok().body(employees);
        } catch (Exception e) {
            logger.error("Error searching employees by name: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching employees by name");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateEmployeeInfo(@RequestBody EmployeeDTO employee) {
        try {
            Employee updatedEmployee = service.updateEmployeeInfo(employee);
            logger.info("Updated employee info: {}", updatedEmployee);
            return ResponseEntity.ok().body(updatedEmployee);
        } catch (Exception e) {
            logger.error("Error updating employee info: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating employee info");
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Object> removeEmployee(@PathVariable int employeeId) {
        try {
            String message = service.removeEmployee(employeeId);
            logger.info("Removed employee with ID: {}", employeeId);
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            logger.error("Error removing employee: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing employee");
        }
    }
}





/*
@RestController
@RequestMapping("/api/assetrequests")
public class AssetRequestController {
	
	@Autowired
	private IAssetRequest service;
	
	Logger logger = LoggerFactory.getLogger(AssetRequestController.class);

	
	@PostMapping("/add")
	public AssetRequest addAssets(@RequestBody AssetRequest asset) {
		return service.addAssets(asset);
	}
	
	@DeleteMapping("/delete/{requestId}")
	public String deleteAssetRequest(@PathVariable int requestId) {
		 service.deleteAssetRequest(requestId);
		 return "Request Deleted";
	}
	
	@GetMapping("/getbyid/{requestId}")
	public AssetRequest findRequest(@PathVariable int requestId) {
		return service.findRequest(requestId);
	}
	
	@GetMapping("/getall")
    public List<AssetRequest> seacrhAllRequests(){
    	return service.seacrhAllRequests();
    }



}
*/
