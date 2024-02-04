package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;




public interface IAssetsService {
	
	
	public Asset addAsset(AssetDTO assetDTO);

	public Asset updateAsset(Asset asset);

	public AssetDTO getAssetById(int aid);

	public String deleteAssetById(int aid);
	
	public  List<Asset>  getAllAssets();

}
