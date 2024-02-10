package com.hexaware.assetmanagement.restcontroller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.exception.AssetRequestNotFoundException;
import com.hexaware.assetmanagement.service.IAssetRequest;

@RestController
@RequestMapping("/api/assetrequests")
public class AssetRequestController {

    @Autowired
    private IAssetRequest service;

    private static final Logger logger = LoggerFactory.getLogger(AssetRequestController.class);

    @PostMapping("/add")
    public ResponseEntity<Object> addAssets(@RequestBody AssetRequestDTO asset) {
        try {
            AssetRequest addedAsset = service.addAssets(asset);
            logger.info("Asset request added successfully: {}", addedAsset);
            return ResponseEntity.ok().body(addedAsset);
        } catch (Exception e) {
            logger.error("Error adding asset request: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding asset request");
        }
    }

    @DeleteMapping("/delete/{requestId}")
    public ResponseEntity<String> deleteAssetRequest(@PathVariable int requestId) throws AssetRequestNotFoundException {
        try {
            service.deleteAssetRequest(requestId);
            logger.info("Asset request with ID {} deleted successfully", requestId);
            return ResponseEntity.ok().body("Request Deleted");
        } catch (Exception e) {
            logger.error("Error deleting asset request: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting asset request");
        }
    }

    @GetMapping("/getbyid/{requestId}")
    public ResponseEntity<Object> findRequest(@PathVariable int requestId) {
        try {
            AssetRequest assetRequest = service.findRequest(requestId);
            if (assetRequest != null) {
                logger.info("Asset request found: {}", assetRequest);
                return ResponseEntity.ok().body(assetRequest);
            } else {
                logger.warn("Asset request with ID {} not found", requestId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asset request not found");
            }
        } catch (Exception e) {
            logger.error("Error finding asset request: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error finding asset request");
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<Object> searchAllRequests() {
        try {
            List<AssetRequest> assetRequests = service.searchAllRequests();
            if (!assetRequests.isEmpty()) {
                logger.info("Found {} asset requests", assetRequests.size());
                return ResponseEntity.ok().body(assetRequests);
            } else {
                logger.warn("No asset requests found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No asset requests found");
            }
        } catch (Exception e) {
            logger.error("Error searching all asset requests: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching all asset requests");
        }
    }
}

