package com.hexaware.assetmanagement.entities;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
=======
import java.util.Date;
>>>>>>> origin/master

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;

@Entity
=======
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "AssetServiceRequests")
>>>>>>> origin/master
public class AssetServiceRequest {
	
	@Id
	@Column(name = "ServiceRequestID")
	private int serviceRequestId;
<<<<<<< HEAD

	@Column(name = "IssueType")
    private String issueType;
	
	@Column(name = "DateRequested")
    private LocalDate dateRequested;
	
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Name must contain only alphabetic characters")
	@Column(name = "Status")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    
    @JoinColumn(name = "AssetID")
    private Asset asset;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeId")
    private Employee employee;

=======
//	@Column(name = "EmployeeID")
//    private int employeeId;
//	@Column(name = "AssetID")
//    private int assetId;
	@Column(name = "IssueType")
    private String issueType;
	@Column(name = "DateRequested")
    private Date dateRequested;
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Name must contain only alphabetic characters")
	@Column(name = "Status")
    private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID")
    private User users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AssetID")
    private Asset asset;

	public AssetServiceRequest() {
		super();
	}

	public AssetServiceRequest(int serviceRequestId, String issueType, Date dateRequested,
			String status, User users, Asset asset) {
		super();
		this.serviceRequestId = serviceRequestId;
//		this.employeeId = employeeId;
//		this.assetId = assetId;
		this.issueType = issueType;
		this.dateRequested = dateRequested;
		this.status = status;
		this.users = users;
		this.asset = asset;
	}
	
	
/*
	public AssetServiceRequest(int serviceRequestId, String issueType, Date dateRequested,
			String status, Asset asset) {
		super();
		this.serviceRequestId = serviceRequestId;
//		this.employeeId = employeeId;
//		this.assetId = assetId;
		this.issueType = issueType;
		this.dateRequested = dateRequested;
		this.status = status;
		//this.users = users;
		this.asset = asset;
	}
*/
>>>>>>> origin/master
	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
<<<<<<< HEAD

=======
/*
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
*/
>>>>>>> origin/master
	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

<<<<<<< HEAD
	public LocalDate getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(LocalDate dateRequested) {
=======
	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
>>>>>>> origin/master
		this.dateRequested = dateRequested;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

<<<<<<< HEAD
=======
	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

>>>>>>> origin/master
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

<<<<<<< HEAD
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AssetServiceRequest(int serviceRequestId, String issueType, LocalDate dateRequested,
			@Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Name must contain only alphabetic characters") String status,
			Asset asset, Employee employee) {
		super();
		this.serviceRequestId = serviceRequestId;
		this.issueType = issueType;
		this.dateRequested = dateRequested;
		this.status = status;
		this.asset = asset;
		this.employee = employee;
	}

	public AssetServiceRequest() {
		super();
	}
 
	

	
}
=======
//	@Override
//	public String toString() {
//		return "AssetServiceRequest [serviceRequestId=" + serviceRequestId + ", employeeId=" + employeeId + ", assetId="
//				+ assetId + ", issueType=" + issueType + ", dateRequested=" + dateRequested + ", status=" + status
//				+ ", employee=" + employee + ", asset=" + asset + "]";
//	}
    
    
}
>>>>>>> origin/master
