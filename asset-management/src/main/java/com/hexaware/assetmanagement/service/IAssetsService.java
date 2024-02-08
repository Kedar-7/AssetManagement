package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;


public interface IAssetsService {
	public List<Asset> getAllAssets();
	public Asset addAssets(AssetDTO asset);
	public Asset updateAssets(Asset asset);
	public AssetDTO getAssetById(int assetId);
	public Asset getById(int assetId);

	public String deleteAssetById(int assetId);

}