package com.hexaware.assetmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.dto.AssetAuditDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAudit;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.exception.InvalidEntryException;
import com.hexaware.assetmanagement.repository.AssetAuditRepository;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;
import com.hexaware.assetmanagement.repository.EmployeeRepository;

@Service
public class AssetAuditServiceImpl implements IAssetAuditService{
	
	Logger logger = LoggerFactory.getLogger(AssetAuditServiceImpl.class);

	
	@Autowired
	AssetRequestRepository requestRepo;

	@Autowired
	AssetAuditRepository repo;

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired 
	AssetRepository assetRepo;

	@Override
	public List<AssetAudit> displayAllAssetAudit() {
		return repo.findAll();
	}

	@Override
	public AssetAudit addingAssetAudit(AssetAuditDTO assetAuditDTO, int employeeId, int assetId, String status) throws InvalidEntryException {
		Employee emp = employeeRepo.findById(employeeId).orElse(null);
		Asset asset = assetRepo.findById(assetId).orElse(null);
		
		if(emp!=null && asset!=null) {
		AssetAudit audit = new AssetAudit();
		audit.setAssetAuditId(assetAuditDTO.getAssetAuditId());
		audit.setAsset(asset);
		audit.setEmployee(emp);
		if(isValidStatus(status)== true) {
			audit.setStatus(status);
		} else throw new InvalidEntryException("Status: "+status+"is invalid enter('Verified' or 'Pending')");
		return repo.save(audit);}
		
		else throw new InvalidEntryException("Invalid Entry");
		
	}
	
	public boolean isValidStatus(String status) {
		if("Verified".equals(status) || "Pending".equals(status)) {
			return true;
		}
		else return false;
	}
}
