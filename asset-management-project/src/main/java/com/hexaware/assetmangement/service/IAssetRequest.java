package com.hexaware.assetmangement.service;

import java.util.List;

import com.hexaware.assetmangement.entities.AssetRequest;



public interface IAssetRequest {
	
	public AssetRequest addAssets(AssetRequest asset);
	public String deleteAssetRequest(int requestId);
	public AssetRequest findRequest(int requestId);
    public List<AssetRequest> seacrhAllRequests();
}
