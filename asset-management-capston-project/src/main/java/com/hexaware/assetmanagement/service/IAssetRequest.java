package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.AssetRequestDTO;
import com.hexaware.assetmanagement.entities.AssetRequest;
import com.hexaware.assetmanagement.exception.AssetRequestNotFoundException;



public interface IAssetRequest {
	
	public AssetRequest addAssetsRequests(AssetRequestDTO asset,int employeeId,int assetId);
	public String deleteAssetRequest(int requestId) throws AssetRequestNotFoundException;
	public AssetRequest findRequest(int requestId) throws AssetRequestNotFoundException;
    public List<AssetRequest> searchAllRequests();
    public AssetRequest updateRequestStatus(String status, int requestId) throws AssetRequestNotFoundException;
    public List<AssetRequest> ViewAssetEmployeeInfo();

    
}
