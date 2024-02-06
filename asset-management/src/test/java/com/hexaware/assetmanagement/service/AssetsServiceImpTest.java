package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.AssetDTO;
import com.hexaware.assetmanagement.entities.Asset;



@SpringBootTest
class AssetsServiceImpTest {
	
	@Autowired
	IAssetsService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetAllAssets() {
//		List list = service.getAllAssets();
//		boolean flag = list.isEmpty();
//		assertFalse(flag);
		
		List<Asset> assetDTOList = service.getAllAssets();
        assertFalse(assetDTOList.isEmpty());
	}

	@Test
	void testGetAssetById() {
		
//		AssetDTO assets = service.getAssetById(4);
//		assertEquals("Sofa", assets.getAssetName());
		
        AssetDTO assetDTO = service.getAssetById(1);
        assertNotNull(assetDTO);
        assertEquals("Laptop", assetDTO.getAssetName());
	}

	@Test
	void testDeleteAssetById() {
		int assetId = 3;
        String result = service.deleteAssetById(assetId);
        assertNotNull(result);
        assertEquals("Record Deleted", result);
		
		
	}

}