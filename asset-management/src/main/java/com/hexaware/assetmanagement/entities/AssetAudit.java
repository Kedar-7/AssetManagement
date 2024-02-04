package com.hexaware.assetmanagement.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table( name = "AssetAudit")
public class AssetAudit {
	@Id
	@Column(name = "AuditId")
	private int auditId;
//	@Column(name = "EmployeeId")
//    private int employeeId;
//	@Column(name = "AssetId")
//    private int assetId;
	@Column(name = "DateAudited")
    private Date dateAudited;
	@Column(name = "Status")
    private String status;
	
	@ManyToOne
    @JoinColumn(name = "UserID")
    private User users;

    @ManyToOne
    @JoinColumn(name = "AssetID")
    private Asset asset;

	public AssetAudit() {
		super();
	}

	public AssetAudit(int auditId, Date dateAudited, String status, User users,
			Asset asset) {
		super();
		this.auditId = auditId;
//		this.employeeId = employeeId;
//		this.assetId = assetId;
		this.dateAudited = dateAudited;
		this.status = status;
		this.users = users;
		this.asset = asset;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
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
	public Date getDateAudited() {
		return dateAudited;
	}

	public void setDateAudited(Date dateAudited) {
		this.dateAudited = dateAudited;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
//		return "AssetAudit [auditId=" + auditId + ", employeeId=" + employeeId + ", assetId=" + assetId
//				+ ", dateAudited=" + dateAudited + ", status=" + status + ", employee=" + employee + ", asset=" + asset
//				+ "]";
//	}
    
    
}