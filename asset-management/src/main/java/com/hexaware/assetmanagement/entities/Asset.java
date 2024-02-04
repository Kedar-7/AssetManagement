package com.hexaware.assetmanagement.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name= "Assets")
public class Asset {
	
	@Id
	@Column(name= "AssetId")
	private int assetId;
	@Column(name= "AssetNo")
    private String assetNo;
	
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$")
	@Column(name= "AssetName")
    private String assetName;
	
	
	@Column(name= "AssetCategory")
    private String assetCategory;
	@Column(name= "AssetModel")
    private String assetModel;
	@Column(name= "ManufacturingDate")
    private Date manufacturingDate;
	@Column(name= "ExpiryDate")
    private Date expiryDate;
	@Column(name= "AssetValue")
    private BigDecimal assetValue;
	@Column(name= "Status")
    private String status;
	
	@OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<AssetRequest> assetRequests;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<AssetServiceRequest> assetServiceRequests;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
    private List<AssetAudit> assetAudits;

	public Asset() {
		super();
	}

	public Asset(int assetId, String assetNo, String assetName, String assetCategory, String assetModel,
			Date manufacturingDate, Date expiryDate, BigDecimal assetValue, String status,
			List<AssetRequest> assetRequests, List<AssetServiceRequest> assetServiceRequests,
			List<AssetAudit> assetAudits) {
		super();
		this.assetId = assetId;
		this.assetNo = assetNo;
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
		this.status = status;
		this.assetRequests = assetRequests;
		this.assetServiceRequests = assetServiceRequests;
		this.assetAudits = assetAudits;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BigDecimal getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(BigDecimal assetValue) {
		this.assetValue = assetValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AssetRequest> getAssetRequests() {
		return assetRequests;
	}

	public void setAssetRequests(List<AssetRequest> assetRequests) {
		this.assetRequests = assetRequests;
	}

	public List<AssetServiceRequest> getAssetServiceRequests() {
		return assetServiceRequests;
	}

	public void setAssetServiceRequests(List<AssetServiceRequest> assetServiceRequests) {
		this.assetServiceRequests = assetServiceRequests;
	}

	public List<AssetAudit> getAssetAudits() {
		return assetAudits;
	}

	public void setAssetAudits(List<AssetAudit> assetAudits) {
		this.assetAudits = assetAudits;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetNo=" + assetNo + ", assetName=" + assetName + ", assetCategory="
				+ assetCategory + ", assetModel=" + assetModel + ", manufacturingDate=" + manufacturingDate
				+ ", expiryDate=" + expiryDate + ", assetValue=" + assetValue + ", status=" + status + "]";
	}

}