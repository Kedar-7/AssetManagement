package com.hexaware.assetmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.service.IAssetService;



@RestController
@RequestMapping("/asset")

public class AssetRestController {
	
	@Autowired
	IAssetService service;
	@PostMapping("/addNewAsset")
	public Asset addNewAsset(@RequestBody AssetDTO assetDTO) {
		
		return service.addNewAsset(assetDTO);
		
	}
	
	@GetMapping("/displayAllAssets")
	public List<Asset> diplayAllAssets(){
		return service.diplayAllAssets();
		
	
	}
	
	@PutMapping("/updateAsset")
	public Asset updateAsset(@RequestBody AssetDTO assetDTO) throws AssetNotFoundException    {
		return service.updateAsset(assetDTO);
	}
	
	@DeleteMapping("/deleteById/{assetId}")
	public String deleteAssetById(@PathVariable int assetId) {
		return service.deleteAssetById(assetId);
	}
	
	@GetMapping("/displayAssetById/{assetId}")
	public Asset displayAssetById(@PathVariable int assetId) {
		return service.displayAssetById(assetId);
	}
	
	@GetMapping("/displayAssetByCategory/{category}")
	public List<Asset> displayAssetByCategory(@PathVariable String category){
		
		return service.displayAssetByCategory(category);
		
	}
	
	@GetMapping("/displayByName/{name}")
	public List<Asset> displayAssetByName(@PathVariable String name){
		
		return service.displayAssetByName(name);
		
	}
	


}
