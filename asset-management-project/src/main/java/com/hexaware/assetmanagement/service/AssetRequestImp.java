package com.hexaware.assetmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;


@Service
public class AssetRequestImp implements IAssetRequest {
	
	@Autowired
	private AssetRequestRepository repo;
	
	@Autowired
	private IAssetService assetRepo;

	
	Logger logger = LoggerFactory.getLogger(AssetRequestImp.class);

	
	@Override
	public AssetRequest addAssets(AssetRequestDTO asset) {
		logger.info("Asset request added successfully: {}", asset);
		AssetRequest assetRequest= new AssetRequest();
		assetRequest.setRequestId(asset.getRequestId());
		assetRequest.setRequestType(asset.getRequestType());
		assetRequest.setDateRequested(asset.getDateRequested());
		assetRequest.setStatus(asset.getStatus());
		
		return repo.save(assetRequest);
	}

	@Override
	public String deleteAssetRequest(int requestId) {
		 repo.deleteById(requestId);
		 logger.info("Asset request with ID {} deleted successfully", requestId);

		 return "Request Deleted";
	}

	@Override
	public AssetRequest findRequest(int requestId) {
		return repo.findById(requestId).orElse(null);
	}

	@Override
	public List<AssetRequest> searchAllRequests() {
		logger.info("Fetching all asset requests");
        List<AssetRequest> assetRequests = repo.findAll();
        if (!assetRequests.isEmpty()) {
            logger.info("Found {} asset requests", assetRequests.size());
        } else {
            logger.warn("No asset requests found");
        }
        return assetRequests;
    
	}

	

}
