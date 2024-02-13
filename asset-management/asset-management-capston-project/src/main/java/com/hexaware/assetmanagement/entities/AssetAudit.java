package com.hexaware.assetmanagement.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;

@Entity
public class AssetAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assetAuditId;
	private LocalDate dateAudited = LocalDate.now();
	
	@ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "AssetID")
    private Asset asset;
    
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EmployeeID")
    private Employee employee;
	

	private String status;

	public int getAssetAuditId() {
		return assetAuditId;
	}

	public void setAssetAuditId(int assetAuditId) {
		this.assetAuditId = assetAuditId;
	}

	public LocalDate getDateAudited() {
		return dateAudited;
	}

	public void setDateAudited(LocalDate dateAudited) {
		this.dateAudited = dateAudited;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AssetAudit(int assetAuditId, LocalDate dateAudited, Asset asset, Employee employee, String status) {
		super();
		this.assetAuditId = assetAuditId;
		this.dateAudited = dateAudited;
		this.asset = asset;
		this.employee = employee;
		this.status = status;
	}

	public AssetAudit() {
		super();
	}
	
	
	
	
}
