package com.hexaware.assetmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.assetmanagement.entities.AssetRequest;



@Repository
public interface AssetRequestRepository extends JpaRepository<AssetRequest, Integer>{
	
	@Query("UPDATE AssetRequest ar SET ar.status = ?1 WHERE ar.requestId = ?2")
	public AssetRequest updateAssetRequestStatus(String status, int assetRequestId);

	@Query("select ar from AssetRequest ar where ar.status = 'Approved' ")
	public List<AssetRequest> ViewAssetEmployeeInfo();


}
