package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.service.IAssetRequest;

@RestController
@RequestMapping("/api/assetrequests")
public class AssetRequestController {
	
	@Autowired
	IAssetRequest service;

	@GetMapping("/getall")
	public List<AssetRequest> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/add")
	public AssetRequest insertRequests(@RequestBody AssetRequestDTO assetRequestDTO) {
		
		return service.addAssets(assetRequestDTO);
	}
	
	@GetMapping("/getbyid/{requestId}")
	public AssetRequestDTO getById(@PathVariable int requestId) {
		return service.getById(requestId);
	}
}
