package com.hexaware.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;

public interface IAssetService {

	public Asset addNewAsset(AssetDTO assetDTO);
	public List<Asset> displayAllAssets();
	public Asset updateAsset(AssetDTO assetDTO);
	public String deleteAssetById(int assetId);
	public Optional<Asset> displayAssetById(int assetId);
	public List<Asset> displayAssetByCategory(String category);
	public List<Asset> displayAssetByName(String name);
	
	
}