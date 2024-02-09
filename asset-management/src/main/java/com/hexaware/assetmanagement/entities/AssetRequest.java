package com.hexaware.assetmanagement.entities;

import java.util.Date;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
=======
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
>>>>>>> origin/master
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD

@Entity
public class AssetRequest {
	
	@Id
	private int requestId;
	

    private String requestType;
    private Date dateRequested;
    private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EmployeeID")
	@JsonBackReference
    private Employee employee;
=======
import jakarta.persistence.Table;

@Entity
@Table(name = "AssetRequests")
public class AssetRequest {
	
	@Id
	@Column(name = "RequestId")
	private int requestId;
	/*
	@Column(name = "EmployeeId")
    private int employeeId;
	@Column(name = "AssetId")
    private int assetId;
    */
	@Column(name = "RequestType")
    private String requestType;
	@Column(name = "DateRequested")
    private Date dateRequested;
	@Column(name = "Status")
    private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID")
    private User users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AssetID")
    private Asset asset;
>>>>>>> origin/master

	public AssetRequest() {
		super();
	}

<<<<<<< HEAD
=======
	public AssetRequest(int requestId, String requestType, Date dateRequested,
			String status, User users, Asset asset) {
		super();
		this.requestId = requestId;
//		this.employeeId = employeeId;
//		this.assetId = assetId;
		this.requestType = requestType;
		this.dateRequested = dateRequested;
		this.status = status;
		this.users = users;
		this.asset = asset;
	}
	
/*
	public AssetRequest(int requestId, String requestType, Date dateRequested,
			String status, Asset asset) {
		super();
		this.requestId = requestId;
//		this.employeeId = employeeId;
//		this.assetId = assetId;
		this.requestType = requestType;
		this.dateRequested = dateRequested;
		this.status = status;
		//this.users = users;
		this.asset = asset;
	}
*/
>>>>>>> origin/master
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

<<<<<<< HEAD
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
=======
	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

//	@Override
//	public String toString() {
//		return "AssetRequest [requestId=" + requestId + ", employeeId=" + employeeId + ", assetId=" + assetId
//				+ ", requestType=" + requestType + ", dateRequested=" + dateRequested + ", status=" + status
//				+ ", employee=" + employee + ", asset=" + asset + "]";
//	}
    
    
}
>>>>>>> origin/master
