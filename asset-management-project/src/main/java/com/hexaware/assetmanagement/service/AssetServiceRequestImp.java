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
import org.slf4j.Logger;


@Service
public class AssetServiceRequestImp implements IAssetServiceRequestService {

	
	@Autowired
	AssetServiceRequestRepository repo;
	
	@Autowired
	AssetRepository assetRepo;

	
    private static final Logger logger = LoggerFactory.getLogger(AssetServiceRequestImp.class);

	@Override
	public String deleteServiceRequestById(int requestId) {
        logger.info("Deleting service request with ID: {}", requestId);
		repo.deleteById(requestId);
		return "Record Deleted";
	}

	@Override
	public List<AssetServiceRequest> displayAllServiceRequest() {
        logger.info("Fetching all service requests from the database");
		return repo.findAll();
	}

	@Override
	public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId) throws AssetNotFoundException {
       /* Asset asset = assetRepo.findById(assetId).orElse(null);
        
        if(asset!= null) {
        AssetServiceRequest serviceRequest = new AssetServiceRequest();
        serviceRequest.setDateRequested(assetserviceDTO.getDateRequested());
        serviceRequest.setIssueType(assetserviceDTO.getIssueType());
        serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
        serviceRequest.setStatus(assetserviceDTO.getStatus());
        
        serviceRequest.setAsset(asset);
        
        return repo.save(serviceRequest);}
        
        else throw new AssetNotFoundException("Asset with assetId: "+assetId+" not found!!");
    }*/
		
		
		Asset asset = assetRepo.findById(assetId).orElse(null);

        if (asset != null) {
            logger.info("Adding new service request for asset with ID: {}", assetId);
            AssetServiceRequest serviceRequest = new AssetServiceRequest();
            serviceRequest.setDateRequested(assetserviceDTO.getDateRequested());
            serviceRequest.setIssueType(assetserviceDTO.getIssueType());
            serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
            serviceRequest.setStatus(assetserviceDTO.getStatus());
            serviceRequest.setAsset(asset);
            return repo.save(serviceRequest);
        } else {
            logger.error("Failed to add service request. Asset with ID {} not found", assetId);
            throw new AssetNotFoundException("Asset with assetId: " + assetId + " not found!!");
        }
	}
}