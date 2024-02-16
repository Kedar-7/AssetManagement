package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/assetServiceRequest")
public class AssetServiceRequestRestController {

    @Autowired
    private IAssetServiceRequestService service;

    private static final Logger logger = LoggerFactory.getLogger(AssetServiceRequestRestController.class);

    @PostMapping("/addNewRequest/{assetId}/{employeeId}")
    public AssetServiceRequest addServiceRequest(@RequestBody AssetServiceRequestDTO assetserviceDTO, @PathVariable int assetId, @PathVariable int employeeId) throws AssetNotFoundException, EmployeeNotFoundException {
        logger.info("Adding new service request: {}", assetserviceDTO);
        return service.addServiceRequest(assetserviceDTO, assetId, employeeId);
    }

    @DeleteMapping("/deleteById/{requestId}")
    public String deleteServiceRequestById(@PathVariable int requestId) {
        logger.info("Deleting service request with ID: {}", requestId);
        return service.deleteServiceRequestById(requestId);
    }

    @GetMapping("/displayAllRequests")
    public List<AssetServiceRequest> displayAllServiceRequest() {
        logger.info("Displaying all service requests");
        return service.displayAllServiceRequest();
    }

    @GetMapping("/displayById/{requestId}")
    public AssetServiceRequest displayServiceRequestById(@PathVariable int requestId) throws AssetServiceRequestNotFoundException {
        logger.info("Displaying service request with ID: {}", requestId);
        return service.displayRequestById(requestId);
    }
}