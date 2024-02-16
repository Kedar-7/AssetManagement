package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.AssetAuditDTO;
import com.hexaware.assetmanagement.entities.Asset;
import com.hexaware.assetmanagement.entities.AssetAudit;
import com.hexaware.assetmanagement.entities.Employee;
import com.hexaware.assetmanagement.exception.InvalidEntryException;
import com.hexaware.assetmanagement.repository.AssetAuditRepository;
import com.hexaware.assetmanagement.repository.AssetRepository;
import com.hexaware.assetmanagement.repository.AssetRequestRepository;
import com.hexaware.assetmanagement.repository.EmployeeRepository;


@SpringBootTest
class AssetAuditServiceImplTest {
	
	@Autowired
	private IAssetAuditService service;
	
	@Autowired
	private AssetRequestRepository requestRepo;

	@Autowired
	private AssetAuditRepository repo;

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired 
	private AssetRepository assetRepo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testDisplayAllAssetAudit() {
        List<AssetAudit> result = service.displayAllAssetAudit();
        
        assertNotNull(result);
        assertEquals(0, result.size());
	}

	@Test
	void testAddingAssetAudit() throws InvalidEntryException {
        AssetAuditDTO assetAuditDTO = new AssetAuditDTO(); 
        assetAuditDTO.setAssetAuditId(501); 
        assetAuditDTO.setStatus("Pending");
        
        int employeeId = 1;
        int assetId = 1; 
        String status = "Completed"; 
        Employee emp = new Employee(); 
        
        Asset asset = new Asset(); 
        
        AssetAudit audit = service.addingAssetAudit(assetAuditDTO, employeeId, assetId, status);
        
        assertNotNull(audit);
        assertEquals(assetAuditDTO.getAssetAuditId(), audit.getAssetAuditId());
        assertEquals(emp, audit.getEmployee());
        assertEquals(asset, audit.getAsset());
        assertEquals(status, audit.getStatus());
	}

}
