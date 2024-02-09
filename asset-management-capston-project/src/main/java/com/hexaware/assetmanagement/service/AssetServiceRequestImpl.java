package com.hexaware.assetmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

import ch.qos.logback.classic.Logger;

@Service
public class AssetServiceRequestImpl implements IAssetServiceRequestService {

	
	@Autowired
	AssetServiceRequestRepository repo;
	
	@Autowired
	AssetRepository assetRepo;
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public String deleteServiceRequestById(int requestId) {

		repo.deleteById(requestId);
		return "Record Deleted";
	}

	@Override
	public List<AssetServiceRequest> displayAllServiceRequest() {
		return repo.findAll();
	}

	@Override
	public AssetServiceRequest addServiceRequest(AssetServiceRequestDTO assetserviceDTO, int assetId , int employeeId) throws AssetNotFoundException, EmployeeNotFoundException {
        Asset asset = assetRepo.findById(assetId).orElse(null);
        Employee emp = empRepo.findById(employeeId).orElse(null);
   
       
        
        if(asset!= null && emp !=null ) {
        AssetServiceRequest serviceRequest = new AssetServiceRequest();
        serviceRequest.setDateRequested(LocalDate.now());
        serviceRequest.setIssueType(assetserviceDTO.getIssueType());
        serviceRequest.setServiceRequestId(assetserviceDTO.getServiceRequestId());
        serviceRequest.setStatus("Pending");
        
        serviceRequest.setAsset(asset);
        serviceRequest.setEmployee(emp);
        
        return repo.save(serviceRequest);}
        
        else if(asset==null) {throw new AssetNotFoundException("Asset with assetId: "+assetId+" not found!!");}
        else if(emp == null) {throw new EmployeeNotFoundException("Employee with employeeId: "+employeeId+" not found!!");}
        else if(emp ==null && asset==null) {throw new AssetNotFoundException("Invalid asset and employee Id");}
        else return null;
		
        
    }

	@Override
	public AssetServiceRequest displayRequestById(int requestId) throws AssetServiceRequestNotFoundException {
		
		AssetServiceRequest serviceRequest = repo.findById(requestId).orElse(null);
		
		if(serviceRequest != null) {
			return serviceRequest;
		}
		
		else throw new AssetServiceRequestNotFoundException("Service Request of ID: "+requestId+" not found!!");
		
	}




}
