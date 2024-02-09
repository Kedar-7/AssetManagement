package com.hexaware.assetmanagement.service;

import java.util.List;


import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;

public interface IAssetServiceRequestService {
	

	
	public String deleteServiceRequestById(int requestId);

	public List<AssetServiceRequest> displayAllServiceRequest();

	AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId) throws AssetNotFoundException;
	
	
}
