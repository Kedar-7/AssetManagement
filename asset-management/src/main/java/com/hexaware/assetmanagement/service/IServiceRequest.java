package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;

public interface IServiceRequest {
	public List<AssetServiceRequest> getAllServiceRequests();
    public String deleteServiceRequests(int serviceRequestId);

}
