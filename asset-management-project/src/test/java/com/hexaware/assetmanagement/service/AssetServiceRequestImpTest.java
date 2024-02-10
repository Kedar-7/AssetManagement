package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;

@SpringBootTest
class AssetServiceRequestImpTest {

	
	@Autowired
	private IAssetServiceRequestService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testDeleteServiceRequestById() {
		int requestId = 1;
        String result = service.deleteServiceRequestById(requestId);
        assertNotNull(result);
        assertEquals("Record Deleted", result);
	}

	@Test
	void testDisplayAllServiceRequest() {
		List<AssetServiceRequest> serviceRequests = service.displayAllServiceRequest();
        assertNotNull(serviceRequests);
	}

	@Test
	void testAddServiceRequest() {
		fail("Not yet implemented");
	}

}
