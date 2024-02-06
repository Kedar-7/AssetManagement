package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.service.IAssetRequest;
import com.hexaware.assetmanagement.service.IUserService;

@RestController
@RequestMapping("/api/assetrequest")
public class AssetRequestController {
	
Logger logger = LoggerFactory.getLogger(UserRestController.class);

	
	@Autowired
	IAssetRequest service;

	@PostMapping("/add")
	public AssetRequest addAssetRequest(@RequestBody AssetRequestDTO assetRequestDTO) {

		return service.addAssetRequest(assetRequestDTO);
	}
	
	@GetMapping("/getall")
	public List<AssetRequest> getAllAssetRequest() {
		
		return service.getAllAssetRequest();
	}

	

}
