package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;
import com.hexaware.assetmanagement.repository.AssetsRepository;
import com.hexaware.assetmanagement.repository.UserRepository;

@Service
public class AssetRequestImp implements IAssetRequest {

	
	@Autowired
	AssetsRepository repo;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AssetRequestRepository assetRequestRepo;
	
	@Override
	public AssetRequest addAssetRequest(AssetRequestDTO assetDTO) {
		AssetRequest assetrequest = new AssetRequest(); 

	
		assetrequest.setRequestId(assetDTO.getRequestId());
		assetrequest.setDateRequested(assetDTO.getDateRequested());
		assetrequest.setRequestType(assetDTO.getRequestType());
		assetrequest.setStatus(assetDTO.getStatus());
		
		 Asset asset = repo.findById(assetDTO.getAssetId())
                 .orElseThrow(() -> new RuntimeException("Asset not found with id: " + assetDTO.getAssetId()));
		 
		 assetrequest.setAsset(asset);
		 
		 User user = userRepo.findById(assetDTO.getUserId())
                 .orElseThrow(() -> new RuntimeException("User not found with id: " + assetDTO.getUserId()));
		 
		 assetrequest.setUsers(user);
		 
		 return assetRequestRepo.save(assetrequest);
		
	}

	@Override
	public AssetRequest updateAssetRequest(AssetRequest asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetRequestDTO getAssetRequestById(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAssetRequestById(int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/getall")
	@Override
	public List<AssetRequest> getAllAssetRequest() {
		
		return assetRequestRepo.findAll();
	}

	
	

}
