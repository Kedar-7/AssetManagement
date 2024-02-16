package com.hexaware.assetmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetServiceRequestDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetServiceRequest;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.AssetNotFoundException;
import com.hexaware.assetmanagement.exception.AssetRequestNotFoundException;
import com.hexaware.assetmanagement.exception.AssetServiceRequestNotFoundException;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.exception.InvalidEntryException;
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
	
    private Logger logger = LoggerFactory.getLogger(AssetServiceRequestImpl.class);


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
	public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId , int employeeId) throws AssetNotFoundException, EmployeeNotFoundException {
        Asset asset = assetRepo.findById(assetId).orElse(null);
        Employee emp = empRepo.findById(employeeId).orElse(null);
   
       
        
        if(asset!= null && emp !=null ) {
        logger.info("Adding service request for asset with ID: {} and employee with ID: {}", assetId, employeeId);

        AssetServiceRequest serviceRequest = new AssetServiceRequest();
        serviceRequest.setDateRequested(LocalDate.now());
        serviceRequest.setIssueType(assetserviceDTO.getIssueType());
        serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
        serviceRequest.setStatus("Pending");
        
        serviceRequest.setAsset(asset);
        serviceRequest.setEmployee(emp);
        
        return repo.save(serviceRequest);}
        
        else if(asset==null) {
        	throw new AssetNotFoundException("Asset with assetId: "+assetId+" not found!!");
        	}
        else if(emp == null) {
        	throw new EmployeeNotFoundException("Employee with employeeId: "+employeeId+" not found!!");
        	}
        
        else return null;
		
        
    }

	@Override
	public AssetServiceRequest displayRequestById(int requestId) throws AssetServiceRequestNotFoundException {
        logger.info("Displaying service request with ID: {}", requestId);

		AssetServiceRequest serviceRequest = repo.findById(requestId).orElse(null);
		
		if(serviceRequest != null) {
			return serviceRequest;
		}
		
		else {
            logger.error("Failed to find service request. Service request with ID {} not found", requestId);
			throw new AssetServiceRequestNotFoundException("Service Request of ID: "+requestId+" not found!!");
		}
		
	}
	
	public AssetServiceRequest updateAssetRequestStatus(String status, int requestId) throws InvalidEntryException, AssetRequestNotFoundException {

		AssetServiceRequest assetServiceRequest = repo.findById(requestId).orElse(null);
		logger.info("Updataing asset request status");

		if(assetServiceRequest != null) {
			
			if(isValidStatus(status)) {
				assetServiceRequest.setStatus(status);
				return repo.save(assetServiceRequest);
			}else throw new InvalidEntryException("Status: "+status+"is invalid enter('Approved' or 'Pending')");
		}
		else throw new AssetRequestNotFoundException("Asset Request with ID: "+requestId+" doesn't exist!!");
		
	}
	
	public boolean isValidStatus(String status) {
		if("In Progress".equals(status) || "Pending".equals(status)) {
			return true;
		}
		return false;
	}



}
