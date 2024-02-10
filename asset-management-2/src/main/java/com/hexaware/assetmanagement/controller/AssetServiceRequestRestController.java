package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;
import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.exception.AssetServiceRequestNotFoundException;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IAssetServiceRequestService;

@RestController
@RequestMapping("/asseetServiceRequest")
public class AssetServiceRequestRestController {

	@Autowired
	IAssetServiceRequestService service;


	@PostMapping("/addNewRequest/{assetId}/{employeeId}")
	public AssetServiceRequest addServiceRequest(@RequestBody AssetServiceRequestDTO assetserviceDTO,@PathVariable int assetId , @PathVariable int employeeId) throws AssetNotFoundException, EmployeeNotFoundException{
		
		return service.addServiceRequest(assetserviceDTO, assetId,employeeId);
	}

	@DeleteMapping("deleteById/{requestId}")
	public String deleteServiceRequestById(@PathVariable int requestId) {
		
		return service.deleteServiceRequestById(requestId);
	}
	
	
	@GetMapping("/displayAllRequests")
	public List<AssetServiceRequest> displayAllServiceRequest(){
		
		return service.displayAllServiceRequest();
	}
	
	@GetMapping("/displayById/{requestId}")
	public AssetServiceRequest displayServiceRequestById(@PathVariable int requestId) throws AssetServiceRequestNotFoundException {
		return service.displayRequestById(requestId);
	}

}
