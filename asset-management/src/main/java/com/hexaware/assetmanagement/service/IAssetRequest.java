package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;

public interface IAssetRequest {
//    void borrowAsset(int userId, int assetId);
//    void returnAsset(int requestId);
    
	public AssetRequest addAssets(AssetRequestDTO asset);
	public String deleteAssetById(int requestId);
	public AssetRequestDTO getById(int requestId);
    public List<AssetRequest> getAll();
}