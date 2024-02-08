package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.repository.AssetsRepository;

@Service
public class AssetsServiceImp implements IAssetsService{
	
	@Autowired
	private AssetsRepository repo;
	
	
	@Override
	public List<Asset> getAllAssets() {
		return repo.findAll();
	}


	@Override
	public Asset addAssets(AssetDTO assetDTO) {
		
		Asset asset = new Asset();
		asset.setAssetId(assetDTO.getAssetId());
		asset.setAssetCategory(assetDTO.getAssetCategory());
		asset.setAssetModel(assetDTO.getAssetModel());
		asset.setAssetName(assetDTO.getAssetName());
		asset.setAssetNo(assetDTO.getAssetNo());
		asset.setAssetValue(assetDTO.getAssetValue());
		asset.setExpiryDate(assetDTO.getExpiryDate());
		asset.setManufacturingDate(assetDTO.getManufacturingDate());
		asset.setStatus(assetDTO.getStatus());
		
		return repo.save(asset);
	}


	@Override
	public Asset updateAssets(Asset asset) {
		return repo.save(asset);
	}


	@Override
	public AssetDTO getAssetById(int assetId) {
		Asset asset =  repo.findById(assetId).orElse(null);
		
		AssetDTO assetDTO = new AssetDTO();
		assetDTO.setAssetId(asset.getAssetId());
		assetDTO.setAssetCategory(asset.getAssetCategory());
		assetDTO.setAssetModel(asset.getAssetModel());
		assetDTO.setAssetName(asset.getAssetName());
		assetDTO.setAssetNo(asset.getAssetNo());
		assetDTO.setAssetValue(asset.getAssetValue());
		assetDTO.setExpiryDate(asset.getExpiryDate());
		assetDTO.setManufacturingDate(asset.getManufacturingDate());
		assetDTO.setStatus(asset.getStatus());
		
		return assetDTO;
	}


	@Override
	public String deleteAssetById(int assetId) {
		 repo.deleteById(assetId);
		 return "Record Deleted";
	}


	@Override
	public Asset getById(int assetId) {
		return repo.findById(assetId).orElse(null);
	}

}