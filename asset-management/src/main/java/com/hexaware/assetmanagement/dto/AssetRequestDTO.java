package com.hexaware.assetmanagement.dto;

import java.util.Date;

public class AssetRequestDTO {
	private int requestId;
    private int userId;
    private int assetId;
    private String requestType;
    private Date dateRequested;
    private String status;
    
    public AssetRequestDTO() {
        // Default constructor
    }

	public AssetRequestDTO(int requestId, int userId, int assetId, String requestType, Date dateRequested,
			String status) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.assetId = assetId;
		this.requestType = requestType;
		this.dateRequested = dateRequested;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int employeeId) {
		this.userId = employeeId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int userId) {
		this.assetId = userId;
	}

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

	@Override
	public String toString() {
		return "AssetRequest [requestId=" + requestId + ", employeeId=" + userId + ", assetId=" + assetId
				+ ", requestType=" + requestType + ", dateRequested=" + dateRequested + ", status=" + status + "]";
	}
}