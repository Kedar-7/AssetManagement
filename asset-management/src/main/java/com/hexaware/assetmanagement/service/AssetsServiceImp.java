package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.repository.AssetsRepository;

@Service
public class AssetsServiceImp implements IAssetsService{
	
	@Autowired
	AssetsRepository repo;
	
	
	@Override
	public List<Asset> getAllAssets() {
		return repo.findAll();
	}


	@Override
	public Asset addAssets(Asset asset) {
		return repo.save(asset);
	}


	@Override
	public Asset updateAssets(Asset asset) {
		return repo.save(asset);
	}


	@Override
	public Asset getAssetById(int assetId) {
		return repo.findById(assetId).orElse(null);
	}


	@Override
	public String deleteAssetById(int assetId) {
		 repo.deleteById(assetId);
		 return "Record Deleted";
	}

}