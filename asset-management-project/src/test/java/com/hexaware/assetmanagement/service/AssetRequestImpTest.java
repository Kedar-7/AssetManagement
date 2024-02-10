package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.entities.AssetRequest;

@SpringBootTest
class AssetRequestImpTest {

	@Autowired
	private IAssetRequest service;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddAssets() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAssetRequest() {
		int requestId = 301;
        String result = service.deleteAssetRequest(requestId);
        assertEquals("Request Deleted", result);
	}

	@Test
	void testFindRequest() {
		  int requestId = 1;
	        AssetRequest foundAssetRequest = service.findRequest(requestId);
	        assertNotNull(foundAssetRequest);
	        assertEquals(requestId, foundAssetRequest.getRequestId());
	}

	@Test
	void testSearchAllRequests() {
		List<AssetRequest> assetRequests = service.searchAllRequests();
        assertNotNull(assetRequests);
        assertTrue(assetRequests.size() > 0);
	}

}
