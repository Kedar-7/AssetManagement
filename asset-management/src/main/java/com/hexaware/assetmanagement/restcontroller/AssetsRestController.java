package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.service.IAssetsService;

@RestController
@RequestMapping("/api/assets")
public class AssetsRestController {
	@Autowired
	IAssetsService service;
	
	@GetMapping("/getall")
	public List<Asset> getAll(){
		return service.getAllAssets();
	}
	
	@PostMapping("/add")
	public Asset insertAssets(@RequestBody AssetDTO assetDTO) {
		return service.addAssets(assetDTO);
	}
	@PutMapping("/update")
	public Asset updateAssets(@RequestBody  Asset asset) {
		return service.updateAssets(asset);
	}
	
	@GetMapping("/getbyid/{assetId}")
	public AssetDTO getAssetById(@PathVariable int assetId) {
		return service.getAssetById(assetId);
	}
	
	@DeleteMapping("/delete/{assetId}")
	public String deleteAssetById(@PathVariable int assetId) {
		return service.deleteAssetById(assetId);
		
	}
}