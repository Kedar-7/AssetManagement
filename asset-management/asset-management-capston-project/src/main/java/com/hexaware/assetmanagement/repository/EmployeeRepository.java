package com.hexaware.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.assetmanagement.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("Select e from Employee e Where e.employeeName LIKE :empName%")
	public Optional<Employee> employeesByName(String empName);

	@Query("Select e from Employee e Where e.email LIKE :email%")
	 Optional<Employee> findByEmail(String email);
	
	

}
