package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;



public interface IAssetRequest {
	
	public AssetRequest addAssetsRequests(AssetRequestDTO asset,int employeeId,int assetId);
	public String deleteAssetRequest(int requestId);
	public AssetRequest findRequest(int requestId);
    public List<AssetRequest> searchAllRequests();
}
