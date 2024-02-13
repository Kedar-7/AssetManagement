package com.hexaware.assetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.assetmanagement.entities.AssetAudit;

@Repository
public interface AssetAuditRepository extends JpaRepository<AssetAudit, Integer>{

}
