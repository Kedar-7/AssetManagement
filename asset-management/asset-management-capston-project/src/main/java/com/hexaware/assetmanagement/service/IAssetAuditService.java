package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetAuditDTO;
import com.hexaware.assetmanagement.entities.AssetAudit;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.exception.InvalidEntryException;

public interface IAssetAuditService {
	
	public List<AssetAudit> displayAllAssetAudit();
	AssetAudit addingAssetAudit(AssetAuditDTO assetAuditDTO, int employeeId, int assetId, String status) throws InvalidEntryException;

}
