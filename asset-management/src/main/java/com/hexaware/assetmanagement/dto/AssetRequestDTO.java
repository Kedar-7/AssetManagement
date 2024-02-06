package com.hexaware.assetmanagement.dto;

import java.util.Date;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AssetRequestDTO {

	private int requestId;
    private int assetId;
	private int userId;
    private String requestType;
    private Date dateRequested;
    private String status;
    private User users;
    private Asset asset;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public AssetRequestDTO(int requestId, int assetId, int userId, String requestType, Date dateRequested,
			String status, User users, Asset asset) {
		super();
		this.requestId = requestId;
		this.assetId = assetId;
		this.userId = userId;
		this.requestType = requestType;
		this.dateRequested = dateRequested;
		this.status = status;
		this.users = users;
		this.asset = asset;
	}
	public AssetRequestDTO() {
		super();
	}
    
    
    
    
}

    