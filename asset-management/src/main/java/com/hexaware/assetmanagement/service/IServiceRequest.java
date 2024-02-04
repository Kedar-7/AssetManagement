package com.hexaware.assetmanagement.service;

public interface IServiceRequest {
	void createServiceRequest(int userId, String description);
    void updateServiceRequestStatus(int serviceRequestId, String status);

}
