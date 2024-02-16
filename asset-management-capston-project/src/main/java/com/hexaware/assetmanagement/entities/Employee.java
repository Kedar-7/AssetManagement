package com.hexaware.assetmanagement.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	@Id
    @Column(name= "EmployeeId")
	private int employeeId;
    @Column(name= "EmployeeName")
	@Pattern(regexp = "^[A-Z][a-z]*\\s[A-Z][a-z]*$")
	private String employeeName;
	@NotNull
	@Email(message = "Invalid email format")
    @Column(name= "Email")
	private String email;
    @Column(name= "Password")
	@Size(min = 6, message = "Password must have at least 6 characters")
	private String password;
    @Column(name= "Gender")
	private String gender;
	@NotNull
	@Size(min = 10, message = "Contact number must be at least 10 digits long")
    @Pattern(regexp = "\\d{10,}", message = "Contact number must contain only digits")
    @Column(name= "Contact")
	private String contact;
    @Column(name= "Address")
	private String address;
    @Column(name= "Role")
	private String role = "User";
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonBackReference
    private List<AssetRequest> assetRequests;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL )
	@JsonBackReference
	private List<AssetServiceRequest> assetServiceRequests;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
	private List<AssetAudit> assetAudit;

	public Employee(int employeeId, String employeeName, String email, String password, String gender, String contact,
			String address, String role, List<AssetRequest> assetRequests,
			List<AssetServiceRequest> assetServiceRequests, List<AssetAudit> assetAudit) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.contact = contact;
		this.address = address;
		this.role = role;
		this.assetRequests = assetRequests;
		this.assetServiceRequests = assetServiceRequests;
		this.assetAudit = assetAudit;
	}

	public List<AssetAudit> getAssetAudit() {
		return assetAudit;
	}

	public void setAssetAudit(List<AssetAudit> assetAudit) {
		this.assetAudit = assetAudit;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<AssetRequest> getAssetRequests() {
		return assetRequests;
	}

	public void setAssetRequests(List<AssetRequest> assetRequests) {
		this.assetRequests = assetRequests;
	}

	public List<AssetServiceRequest> getAssetServiceRequests() {
		return assetServiceRequests;
	}

	public void setAssetServiceRequests(List<AssetServiceRequest> assetServiceRequests) {
		this.assetServiceRequests = assetServiceRequests;
	}



	public Employee() {
		super();
	}
	
	
	
	
}
