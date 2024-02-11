package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetAuditDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAudit;
import com.hexaware.assetmanagement.exception.EmployeeNotFoundException;
import com.hexaware.assetmanagement.service.IAssetAuditService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/assetaudit")
public class AssetAuditController {
	
	@Autowired
	IAssetAuditService service;
	
	@PostMapping("/addNewAssetAudit/{employeeId}/{assetId}/{status}")
	@PreAuthorize("hasAnyAuthority('Admin','User')")
	public AssetAudit addingAssetAudit(@RequestBody AssetAuditDTO assetAuditDTO,@PathVariable int employeeId,@PathVariable int assetId,@PathVariable String status) {
		return service.addingAssetAudit(assetAuditDTO, employeeId, assetId, status);
	}
	
	@GetMapping("/displayAllAudits")
	@PreAuthorize("hasAnyAuthority('Admin')")
	public List<AssetAudit> displayAllAssetAudit(){
		return service.displayAllAssetAudit();
	}
	
	
}
