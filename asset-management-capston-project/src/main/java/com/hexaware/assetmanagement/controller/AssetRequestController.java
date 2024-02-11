package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.exception.AssetRequestNotFoundException;
import com.hexaware.assetmanagement.service.IAssetRequest;

@RestController
@RequestMapping("/assetrequests")
public class AssetRequestController {

    @Autowired
    private IAssetRequest service;

    private static final Logger logger = LoggerFactory.getLogger(AssetRequestController.class);

    
    @PostMapping("/add/{employeeId}/{assetId}")
    public AssetRequest addAssetsRequests(@RequestBody AssetRequestDTO asset, @PathVariable int employeeId, @PathVariable int assetId) {
        logger.info("Adding asset request for employee ID {} and asset ID {}", employeeId, assetId);
        return service.addAssetsRequests(asset, employeeId, assetId);
    }
    
    @DeleteMapping("/delete/{requestId}")
    public String deleteAssetRequest(@PathVariable int requestId) {
        logger.info("Deleting asset request with ID {}", requestId);
        service.deleteAssetRequest(requestId);
        return "Request has been deleted";
    }

    @GetMapping("/getbyid/{requestId}") 
    public AssetRequest findRequest(@PathVariable int requestId) {
        logger.info("Fetching asset request with ID {}", requestId);
        return service.findRequest(requestId);
    }

    @GetMapping("/getall")
    public List<AssetRequest> searchAllRequests(){
        logger.info("Fetching all asset requests");
        return service.searchAllRequests();
    }
    
    @PutMapping("/updateStatus/{status}/{requestId}")
    public AssetRequest updateAssetRequestStatus(@PathVariable String status ,@PathVariable int requestId) throws AssetRequestNotFoundException {
    	logger.info("Admin is Updating Status");
    	return service.updateRequestStatus(status, requestId);
    }
    
    @GetMapping("/displayAssetEmployeeInfo")
    public List<AssetRequest> ViewAssetEmployeeInfo(){
    	logger.info("List of user that posses assets");
    	return service.ViewAssetEmployeeInfo();
    }
    	
    	
}

