package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;



public interface IAssetRequest {
	public AssetRequest addAssetRequest(AssetRequestDTO assetDTO);

	public AssetRequest updateAssetRequest(AssetRequest asset);

	public AssetRequestDTO getAssetRequestById(int aid);

	public String deleteAssetRequestById(int aid);
	
	public  List<AssetRequest>  getAllAssetRequest();
	
	
	
}
