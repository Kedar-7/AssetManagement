package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.service.IAssetsService;
import com.hexaware.userrest.exception.ProductNotFoundException;



@RestController
@RequestMapping("/api/assets")
public class AssetsRestController {
	
	
Logger logger = LoggerFactory.getLogger(AssetsRestController.class);

	
	@Autowired
	IAssetsService service;

	@PostMapping("/add")
	public Asset addAssets(@RequestBody AssetDTO assetsDTO) {

		return service.addAsset(assetsDTO);
	}

	@GetMapping("/get/{aid}")
	public AssetDTO getById(@PathVariable int aid) {
		
		AssetDTO assetDTO = service.getAssetById(aid);

		if (assetDTO.getAssetId() == 0) {

			throw new ProductNotFoundException(HttpStatus.BAD_REQUEST, "Product Not Found for Pid : " + aid);
		}

		return assetDTO;
	}

	@GetMapping("/getall")
	public List<Asset> getAllAssetss() {
		
		return service.getAllAssets();
	}


	
	@DeleteMapping("/delete/{aid}")
	public String deleteById(@PathVariable int aid) {
		
		return service.deleteAssetById(aid);
		
	}
}
