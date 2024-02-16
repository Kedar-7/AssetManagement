package com.hexaware.assetmanagement.service;

import java.util.List;


import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.exception.AssetServiceRequestNotFoundException;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;

public interface IAssetServiceRequestService {
	

	
	public String deleteServiceRequestById(int requestId);

	public List<AssetServiceRequest> displayAllServiceRequest();


	
	public AssetServiceRequest displayRequestById(int requestId) throws AssetServiceRequestNotFoundException;


	public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId, int employeeId)
			throws AssetNotFoundException, EmployeeNotFoundException;
	
}
