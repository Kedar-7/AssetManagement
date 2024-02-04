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
	AssetsRepository repo;
	


	@Override
	public Asset updateAsset(Asset asset) {
		return repo.save(asset);
	}



	@Override
	public String deleteAssetById(int aid) {
		repo.deleteById(aid);
		 return "Record Deleted";
	}

	@Override
	public List<Asset> getAllAssets() {
		return repo.findAll();
	}

	@Override
	public Asset addAsset(AssetDTO AssetDTO) {
		Asset asset= new Asset(); 

		
		asset.setAssetCategory(AssetDTO.getAssetCategory());
		asset.setAssetId(AssetDTO.getAssetId());
		asset.setAssetModel(AssetDTO.getAssetModel());
		asset.setAssetName(AssetDTO.getAssetName());
		asset.setAssetNo(AssetDTO.getAssetNo());
		asset.setAssetValue(AssetDTO.getAssetValue());
		asset.setExpiryDate(AssetDTO.getExpiryDate());
		asset.setManufacturingDate(AssetDTO.getManufacturingDate());
		asset.setStatus(AssetDTO.getStatus());
		

		return repo.save(asset);
	}



	@Override
	public AssetDTO getAssetById(int aid) {
		
		Asset asset= repo.findById(aid).orElse(new Asset());
		
	
		

		AssetDTO assetDTO = new AssetDTO();

		
		assetDTO.setAssetCategory(asset.getAssetCategory());
		assetDTO.setAssetId(asset.getAssetId());
		assetDTO.setAssetModel(asset.getAssetModel());
		assetDTO.setAssetName(asset.getAssetName());
		assetDTO.setAssetNo(asset.getAssetNo());
		assetDTO.setAssetValue(asset.getAssetValue());
		assetDTO.setExpiryDate(asset.getExpiryDate());
		assetDTO.setManufacturingDate(asset.getManufacturingDate());
		assetDTO.setStatus(asset.getStatus());

		
		return  assetDTO;
				
	}


	
}
