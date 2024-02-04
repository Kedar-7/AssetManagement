package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.assetmanagement.entities.Asset;

public interface AssetsRepository extends JpaRepository<Asset, Integer> {

}