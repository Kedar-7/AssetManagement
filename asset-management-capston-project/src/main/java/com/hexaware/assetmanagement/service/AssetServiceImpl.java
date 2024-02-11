package com.hexaware.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.repository.AssetRepository;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	AssetRepository repo;

	@Override
	public Asset addNewAsset(AssetDTO assetDTO) {

		Asset asset = new Asset();

		asset.setAssetCategory(assetDTO.getAssetCategory());
		asset.setAssetId(assetDTO.getAssetId());
		asset.setAssetModel(assetDTO.getAssetModel());
		asset.setAssetName(assetDTO.getAssetName());
		asset.setAssetValue(assetDTO.getAssetValue());
		asset.setExpiryDate(assetDTO.getExpiryDate());
		asset.setManufacturingDate(assetDTO.getManufacturingDate());
		asset.setStatus(assetDTO.getStatus());

		return repo.save(asset);

	}

	@Override
	public List<Asset> diplayAllAssets() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Asset updateAsset(AssetDTO assetDTO) throws AssetNotFoundException{
		
		Asset asset = repo.findById(assetDTO.getAssetId()).orElse(null);
		
		if(asset!= null) {
				
		Asset updateAsset = new Asset();
		
		updateAsset.setAssetCategory(assetDTO.getAssetCategory());
		updateAsset.setAssetId(assetDTO.getAssetId());
		updateAsset.setAssetModel(assetDTO.getAssetModel());
		updateAsset.setAssetName(assetDTO.getAssetName());
		updateAsset.setAssetValue(assetDTO.getAssetValue());
		updateAsset.setExpiryDate(assetDTO.getExpiryDate());
		updateAsset.setManufacturingDate(assetDTO.getManufacturingDate());
		updateAsset.setStatus(assetDTO.getStatus());

		return repo.save(updateAsset);}
		
		else throw new AssetNotFoundException("Invalid data to update");
		
		
	}

	@Override
	public String deleteAssetById(int assetId) {
	    repo.deleteById(assetId);
	    
	    return "Record Deleted";
	}

	@Override
	public Asset displayAssetById(int assetId) {
		
		return repo.findById(assetId).orElse(null);
	}

	@Override
	public List<Asset> displayAssetByCategory(String category) {
		
		return repo.displayAssetByCategory(category);
	}

	@Override
	public List<Asset> displayAssetByName(String name) {
		
		return repo.displayAssetByName(name);
	}

}
