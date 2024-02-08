package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;

@Service
public class AssetRequestImp implements IAssetRequest {

	
	@Autowired
	AssetRequestRepository repo;
	
	@Autowired
	IAssetsService service;
	
	@Autowired
	IUserService user;
	@Override
	public List<AssetRequest> getAll() {
		return repo.findAll();
	}
	@Override
	public String deleteAssetById(int requestId) {
		 repo.deleteById(requestId);
		 return "Record deleted";
	}
	@Override
	public AssetRequestDTO getById(int requestId) {
		AssetRequest assetRequest = new AssetRequest();
		AssetRequestDTO assetRequestDTO = new AssetRequestDTO();
		assetRequestDTO.setRequestId(assetRequest.getRequestId());
		assetRequestDTO.setDateRequested(assetRequest.getDateRequested());
		assetRequestDTO.setRequestType(assetRequest.getRequestType());
		assetRequestDTO.setStatus(assetRequest.getStatus());
//		assetRequestDTO.setAssetId(assetRequest.getAsset().getAssetId());
//		assetRequestDTO.setUserId(assetRequest.getUsers().getUserId());
		Asset asset = assetRequest.getAsset();
        if (asset != null) {
            assetRequestDTO.setAssetId(asset.getAssetId());
        }

        User user = assetRequest.getUsers();
        if (user != null) {
            assetRequestDTO.setUserId(user.getUserId());
        }
		return assetRequestDTO;
		
		
	}
	
	@Override
	public AssetRequest addAssets(AssetRequestDTO assetRequestDTO) {
		AssetRequest asset = new AssetRequest();
		asset.setRequestId(assetRequestDTO.getRequestId());
		asset.setDateRequested(assetRequestDTO.getDateRequested());
		asset.setRequestType(assetRequestDTO.getRequestType());
		asset.setStatus(assetRequestDTO.getStatus());
		
		Asset a = service.getById(assetRequestDTO.getAssetId());
		asset.setAsset(a);
		
		User u = user.getUserById(assetRequestDTO.getUserId());
		asset.setUsers(u);
		
		repo.save(asset);
		return asset;
	}

//	@Override
//	public void borrowAsset(int userId, int assetId) {
//
//	}
//
//	@Override
//	public void returnAsset(int arequestId) {
//
//	}

}
