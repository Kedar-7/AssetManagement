package com.hexaware.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetServiceRequestRepository;

import ch.qos.logback.classic.Logger;

@Service
public class AssetServiceRequestImpl implements IAssetServiceRequestService {

	
	@Autowired
	AssetServiceRequestRepository repo;
	
	@Autowired
	AssetRepository assetRepo;

	@Override
	public String deleteServiceRequestById(int requestId) {

		repo.deleteById(requestId);
		return "Record Deleted";
	}

	@Override
	public List<AssetServiceRequest> displayAllServiceRequest() {
		return repo.findAll();
	}

	@Override
	public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId) throws AssetNotFoundException {
        Asset asset = assetRepo.findById(assetId).orElse(null);
        
        if(asset!= null) {
        AssetServiceRequest serviceRequest = new AssetServiceRequest();
        serviceRequest.setDateRequested(assetserviceDTO.getDateRequested());
        serviceRequest.setIssueType(assetserviceDTO.getIssueType());
        serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
        serviceRequest.setStatus(assetserviceDTO.getStatus());
        
        serviceRequest.setAsset(asset);
        
        return repo.save(serviceRequest);}
        
        else throw new AssetNotFoundException("Asset with assetId: "+assetId+" not found!!");
    }

}
