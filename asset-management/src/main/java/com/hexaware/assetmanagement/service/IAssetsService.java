package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.entities.Asset;


public interface IAssetsService {
	public List<Asset> getAllAssets();
	public Asset addAssets(Asset asset);
	public Asset updateAssets(Asset asset);
	public Asset getAssetById(int assetId);
	public String deleteAssetById(int assetId);

}