package com.hexaware.assetmanagement.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AssetRequests")
public class AssetRequest {
	
	@Id
	@Column(name = "RequestId")
	private int requestId;
	
	@Column(name = "AssetId")
    private int assetId;
	
	@Column(name = "UserId")
	private int userId;

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

	public AssetRequest(int requestId, int assetId, int userId, String requestType, Date dateRequested, String status,
			User users, Asset asset) {
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

	public AssetRequest() {
		super();
	}
    
    



    
}