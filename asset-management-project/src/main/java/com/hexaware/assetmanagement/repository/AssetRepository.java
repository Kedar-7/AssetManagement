package com.hexaware.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.assetmanagement.entities.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{
	
	@Query("SELECT e FROM Asset e WHERE e.assetCategory = :category")
	public List<Asset> displayAssetByCategory(String category);
	
	
	@Query("SELECT e FROM Asset e WHERE e.assetName = :name")
	public List<Asset> displayAssetByName(String name);


}