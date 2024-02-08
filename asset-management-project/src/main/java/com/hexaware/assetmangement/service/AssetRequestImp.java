package com.hexaware.assetmangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hexaware.assetmangement.entities.AssetRequest;
import com.hexaware.assetmangement.repository.AssetRequestRepository;

public class AssetRequestImp implements IAssetRequest {
	
	@Autowired
	private AssetRequestRepository repo;
	
	Logger logger = LoggerFactory.getLogger(AssetRequestImp.class);

	
	@Override
	public AssetRequest addAssets(AssetRequest asset) {
		logger.info("Asset request added successfully: {}", asset);
		return repo.save(asset);
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
	public List<AssetRequest> seacrhAllRequests() {
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
