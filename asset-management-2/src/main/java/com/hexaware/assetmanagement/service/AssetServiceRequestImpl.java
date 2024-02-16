package com.hexaware.assetmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.exception.AssetServiceRequestNotFoundException;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetServiceRequestRepository;
import com.hexaware.assetmanagement.repository.EmployeeRepository;



@Service
public class AssetServiceRequestImpl implements IAssetServiceRequestService {

    @Autowired
    private AssetServiceRequestRepository repo;

    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private EmployeeRepository empRepo;

    private static final Logger logger = LoggerFactory.getLogger(AssetServiceRequestImpl.class);

    @Override
    public String deleteServiceRequestById(int requestId) {
        logger.info("Deleting service request with ID: {}", requestId);
        repo.deleteById(requestId);
        return "Record Deleted";
    }

    @Override
    public List<AssetServiceRequest> displayAllServiceRequest() {
        logger.info("Fetching all service requests from the database");
        return repo.findAll();
    }

    @Override
    public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId, int employeeId)
            throws AssetNotFoundException, EmployeeNotFoundException {
        Asset asset = assetRepo.findById(assetId).orElse(null);
        Employee emp = empRepo.findById(employeeId).orElse(null);

        if (asset != null && emp != null) {
            logger.info("Adding service request for asset with ID: {} and employee with ID: {}", assetId, employeeId);
            AssetServiceRequest serviceRequest = new AssetServiceRequest();
            serviceRequest.setDateRequested(LocalDate.now());
            serviceRequest.setIssueType(assetserviceDTO.getIssueType());
            serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
            serviceRequest.setStatus("Pending");

            serviceRequest.setAsset(asset);
            serviceRequest.setEmployee(emp);

            return repo.save(serviceRequest);
        } else if (asset == null) {
            logger.error("Failed to add service request. Asset with ID {} not found", assetId);
            throw new AssetNotFoundException("Asset with assetId: " + assetId + " not found!!");
        } else if (emp == null) {
            logger.error("Failed to add service request. Employee with ID {} not found", employeeId);
            throw new EmployeeNotFoundException("Employee with employeeId: " + employeeId + " not found!!");
        } else if (emp == null && asset == null) {
            logger.error("Failed to add service request. Invalid asset and employee IDs");
            throw new AssetNotFoundException("Invalid asset and employee Id");
        } else {
            logger.error("Failed to add service request. Unknown error occurred");
            return null;
        }

    }

    @Override
    public AssetServiceRequest displayRequestById(int requestId) throws AssetServiceRequestNotFoundException {

        AssetServiceRequest serviceRequest = repo.findById(requestId).orElse(null);

        if (serviceRequest != null) {
            return serviceRequest;
        } else {
            logger.error("Failed to find service request. Service request with ID {} not found", requestId);
            throw new AssetServiceRequestNotFoundException("Service Request of ID: " + requestId + " not found!!");
        }
    }

}