package com.hexaware.assetmanagement.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.AssetRequestNotFoundException;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;
import com.hexaware.assetmanagement.repository.EmployeeRepository;


@Service
public class AssetRequestImp implements IAssetRequest {
	
	@Autowired
	private AssetRequestRepository repo;
	
	@Autowired
	private AssetRepository assetRepo;
	
	@Autowired
	private EmployeeRepository empRepo;

	
	Logger logger = LoggerFactory.getLogger(AssetRequestImp.class);

	
	@Override
	public AssetRequest addAssetsRequests(AssetRequestDTO assetDTO, int employeeId, int assetId) {
		Employee emp = empRepo.findById(employeeId).orElse(null);
		Asset asset = assetRepo.findById(assetId).orElse(null);
		logger.info("Asset request added successfully: {}", assetDTO);
		AssetRequest assetRequest= new AssetRequest();
		assetRequest.setRequestId(assetDTO.getRequestId());
		assetRequest.setRequestType(assetDTO.getRequestType());
		assetRequest.setEmployee(emp);
		assetRequest.setAsset(asset);
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
	    logger.info("Finding request by ID: {}", requestId);
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

	@Override
	public AssetRequest updateRequestStatus(String status, int requestId) throws AssetRequestNotFoundException {
		
		AssetRequest assetRequest = repo.findById(requestId).orElse(null);
		
		if(assetRequest != null) {
			
			assetRequest.setStatus(status);
			
			return repo.save(assetRequest);
		}
		else throw new AssetRequestNotFoundException("Asset Request with ID: "+requestId+" doesn't exist!!");
		
		
	}

	@Override
	public List<AssetRequest> ViewAssetEmployeeInfo() {
		// TODO Auto-generated method stub
		return repo.ViewAssetEmployeeInfo();
	}


	

}
