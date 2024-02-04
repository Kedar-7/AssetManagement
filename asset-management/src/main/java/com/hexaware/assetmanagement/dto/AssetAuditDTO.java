package com.hexaware.assetmanagement.dto;

import java.util.Date;

public class AssetAuditDTO {
	private int auditId;
    private int employeeId;
    private int assetId;
    private Date dateAudited;
    private String status;

    // Constructors
    public AssetAuditDTO() {
        // Default constructor
    }

	public AssetAuditDTO(int auditId, int employeeId, int assetId, Date dateAudited, String status) {
		super();
		this.auditId = auditId;
		this.employeeId = employeeId;
		this.assetId = assetId;
		this.dateAudited = dateAudited;
		this.status = status;
	}

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

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

	@Override
	public String toString() {
		return "AssetAudit [auditId=" + auditId + ", employeeId=" + employeeId + ", assetId=" + assetId
				+ ", dateAudited=" + dateAudited + ", status=" + status + "]";
	}
}