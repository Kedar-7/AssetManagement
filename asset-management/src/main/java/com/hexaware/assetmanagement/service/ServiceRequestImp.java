package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.repository.AssetServiceRepository;

@Service
public class ServiceRequestImp implements IServiceRequest {

	@Autowired
	AssetServiceRepository repo;

	@Override
	public List<AssetServiceRequest> getAllServiceRequests() {
		return repo.findAll();
	}

	@Override
	public String deleteServiceRequests(int serviceRequestId) {
		repo.deleteById(serviceRequestId);
		return "Service Requests Deleted:";
		
	}

}
