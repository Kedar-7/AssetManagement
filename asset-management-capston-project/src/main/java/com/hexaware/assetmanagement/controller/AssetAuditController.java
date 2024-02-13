package com.hexaware.assetmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.dto.AssetAuditDTO;

import com.hexaware.assetmanagement.entities.AssetAudit;
import com.hexaware.assetmanagement.exception.InvalidEntryException;
import com.hexaware.assetmanagement.service.IAssetAuditService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/assetaudit")
public class AssetAuditController {

	@Autowired
	IAssetAuditService service;

	private Logger logger = LoggerFactory.getLogger(AssetAuditController.class);

	@PostMapping("/addNewAssetAudit/{employeeId}/{assetId}/{status}")
	@PreAuthorize("hasAnyAuthority('Admin','User')")
	public AssetAudit addingAssetAudit(@RequestBody AssetAuditDTO assetAuditDTO, @PathVariable int employeeId,
			@PathVariable int assetId, @PathVariable String status) throws InvalidEntryException {
		logger.info("Adding new asset audit with employeeId: {}, assetId: {}, status: {}", employeeId, assetId, status);

		return service.addingAssetAudit(assetAuditDTO, employeeId, assetId, status);
	}

	@GetMapping("/displayAllAudits")
	@PreAuthorize("hasAnyAuthority('Admin')")
	public List<AssetAudit> displayAllAssetAudit() {
		logger.info("Displaying all asset audits");
		return service.displayAllAssetAudit();
	}

	@DeleteMapping("/deleteAudit/{assetAuditId}")
	@PreAuthorize("hasAnyAuthority('Admin')")
	public String removeAuditRequest(int assetAuditId) {
		return service.removeAuditRequest(assetAuditId);
	}

}
