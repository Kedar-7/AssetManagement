package com.hexaware.assetmanagement.dto;

import java.util.Date;

public class AssetServiceRequestDTO {
	private int serviceRequestId;
    private int employeeId;
    private int assetId;
    private String issueType;
    private Date dateRequested;
    private String status;
    
    public AssetServiceRequestDTO() {
        // Default constructor
    }

	public AssetServiceRequestDTO(int serviceRequestId, int employeeId, int assetId, String issueType, Date dateRequested,
			String status) {
		super();
		this.serviceRequestId = serviceRequestId;
		this.employeeId = employeeId;
		this.assetId = assetId;
		this.issueType = issueType;
		this.dateRequested = dateRequested;
		this.status = status;
	}

	public int getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(int serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
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

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
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

	@Override
	public String toString() {
		return "AssetServiceRequest [serviceRequestId=" + serviceRequestId + ", employeeId=" + employeeId + ", assetId="
				+ assetId + ", issueType=" + issueType + ", dateRequested=" + dateRequested + ", status=" + status
				+ "]";
	}
    
}