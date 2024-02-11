package com.hexaware.assetmanagement.entities;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssetRequest {
	
	@Id
	private int requestId;
	

    private String requestType;
    private LocalDate dateRequested = LocalDate.now();
    
    private String status = "Pending";
	
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "AssetID")
    private Asset asset;
    
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public LocalDate getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(LocalDate dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AssetRequest(int requestId, String requestType, LocalDate dateRequested, String status, Asset asset,
			Employee employee) {
		super();
		this.requestId = requestId;
		this.requestType = requestType;
		this.dateRequested = dateRequested;
		this.status = status;
		this.asset = asset;
		this.employee = employee;
	}

	public AssetRequest() {
		super();
	}

	
	
}
