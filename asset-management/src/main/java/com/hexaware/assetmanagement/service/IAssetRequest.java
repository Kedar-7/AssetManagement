package com.hexaware.assetmanagement.service;

public interface IAssetRequest {
    void borrowAsset(int userId, int assetId);
    void returnAsset(int requestId);
    
}