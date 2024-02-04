package com.hexaware.assetmanagement.service;

public interface IAuditService {
	 void createAuditRequest(int userId, String description);
	    void updateAuditRequestStatus(int auditId, String status);
	   

}
