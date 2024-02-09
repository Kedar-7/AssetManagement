package com.hexaware.assetmanagement.dto;

<<<<<<< HEAD
import java.time.LocalDate;

import com.hexaware.assetmanagement.entities.Asset;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

public class AssetDTO {

	private int assetId;

	private String assetName;
	private String assetCategory;
	private String assetModel;
	private LocalDate manufacturingDate;
	private LocalDate expiryDate;
	private double assetValue;
	private String status;
    private Asset asset;
	public AssetDTO(int assetId, String assetName, String assetCategory, String assetModel, LocalDate manufacturingDate,
			LocalDate expiryDate, double assetValue, String status, Asset asset) {
		super();
		this.assetId = assetId;
=======
import java.math.BigDecimal;
import java.util.Date;

public class AssetDTO {
	private int assetId;
    private String assetNo;
    private String assetName;
    private String assetCategory;
    private String assetModel;
    private Date manufacturingDate;
    private Date expiryDate;
    private BigDecimal assetValue;
    private String status;
    
    public AssetDTO() {
        // Default constructor
    }

	public AssetDTO(int assetId, String assetNo, String assetName, String assetCategory, String assetModel,
			Date manufacturingDate, Date expiryDate, BigDecimal assetValue, String status) {
		super();
		this.assetId = assetId;
		this.assetNo = assetNo;
>>>>>>> origin/master
		this.assetName = assetName;
		this.assetCategory = assetCategory;
		this.assetModel = assetModel;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.assetValue = assetValue;
		this.status = status;
<<<<<<< HEAD
		this.asset = asset;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
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
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}
	public String getStatus() {
		return status;
	}
=======
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

>>>>>>> origin/master
	public void setStatus(String status) {
		this.status = status;
	}

<<<<<<< HEAD
	public AssetDTO() {
		super();
	}
	
	
}
=======
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetNo=" + assetNo + ", assetName=" + assetName + ", assetCategory="
				+ assetCategory + ", assetModel=" + assetModel + ", manufacturingDate=" + manufacturingDate
				+ ", expiryDate=" + expiryDate + ", assetValue=" + assetValue + ", status=" + status + "]";
	}
}
>>>>>>> origin/master
