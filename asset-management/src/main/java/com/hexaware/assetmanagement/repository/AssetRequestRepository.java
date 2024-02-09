package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.AssetRequest;

public interface AssetRequestRepository extends JpaRepository<AssetRequest, Integer>{

}
