package com.hexaware.assetmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.exception.InvalidEntryException;
import com.hexaware.assetmanagement.repository.AssetRepository;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetRepository repo;
	
    private Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);


	@Override
	public Asset addNewAsset(AssetDTO assetDTO) {
        logger.info("Adding new asset: {}", assetDTO);

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
        logger.info("Fetching all assets from the database");
		return repo.findAll();
	}

	@Override
	public Asset updateAsset(AssetDTO assetDTO) throws AssetNotFoundException, InvalidEntryException{
        logger.info("Updating asset: {}", assetDTO);
	

		Asset asset = repo.findById(assetDTO.getAssetId()).orElse(null);

		if (asset != null) {

			Asset updateAsset = new Asset();

			updateAsset.setAssetCategory(assetDTO.getAssetCategory());
			updateAsset.setAssetId(assetDTO.getAssetId());
			updateAsset.setAssetModel(assetDTO.getAssetModel());
			updateAsset.setAssetName(assetDTO.getAssetName());
			updateAsset.setAssetValue(assetDTO.getAssetValue());
			updateAsset.setExpiryDate(assetDTO.getExpiryDate());
			updateAsset.setManufacturingDate(assetDTO.getManufacturingDate());
			
			if(isValidStatus(assetDTO.getStatus())) {
				updateAsset.setStatus(assetDTO.getStatus());
			}else throw new InvalidEntryException("Status: "+assetDTO.getStatus()+"is invalid enter('Available' or 'In Use')");
			

			return repo.save(updateAsset);
		}

		else {
            logger.error("Failed to update asset. Asset with ID {} not found", assetDTO.getAssetId());

			throw new AssetNotFoundException("Invalid data to update");

		}
		
	}

	@Override
	public String deleteAssetById(int assetId) throws AssetNotFoundException{
        logger.info("Deleting asset with ID: {}", assetId);
        Asset asset = repo.findById(assetId).orElse(null);

		if (asset != null) {
			repo.deleteById(assetId);

			return "Record Deleted";
		}

		else {
			logger.error("Failed to Delete asset.");
			throw new AssetNotFoundException("Asset with ID: " + assetId + " not found!!");
	}
	
}
	@Override
	public Asset displayAssetById(int assetId) throws AssetNotFoundException{
        logger.info("Fetching asset by ID: {}", assetId);
        Asset asset = repo.findById(assetId).orElse(null);

		if (asset != null) {
			return repo.findById(assetId).orElse(null);
		} else {
			logger.error("Failed to search the asset.");
			throw new AssetNotFoundException("Asset with ID: " + assetId + " not found!!");
		}
	}

	@Override
	public List<Asset> displayAssetByCategory(String category) throws InvalidEntryException{
        logger.info("Fetching assets by category: {}", category);
        List<Asset> assets = repo.displayAssetByCategory(category);

		if (!assets.isEmpty()) {
			return repo.displayAssetByCategory(category);
		} else {
			logger.error("Failed to search the asset by category.");
			throw new InvalidEntryException("Asset category: " + category + " doesn't exist!!");
		}
	}
	@Override
	public List<Asset> displayAssetByName(String name) throws InvalidEntryException {
        logger.info("Fetching assets by name: {}", name);
        List<Asset> assets = repo.displayAssetByName(name);
		if (!assets.isEmpty()) {
			return repo.displayAssetByName(name);
		}else {
			logger.error("Failed to search the asset by the given name.");

			throw new InvalidEntryException("Asset Name: " +name+ " doesn't exist!!");
	}
	}	
	public boolean isValidStatus(String status) {
		if("Available".equals(status) || "In Use".equals(status)) {
			return true;
		}
		return false;
	}

}
