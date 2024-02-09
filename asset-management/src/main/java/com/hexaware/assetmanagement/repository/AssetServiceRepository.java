package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.AssetServiceRequest;

public interface AssetServiceRepository extends JpaRepository<AssetServiceRequest, Integer> {

}
