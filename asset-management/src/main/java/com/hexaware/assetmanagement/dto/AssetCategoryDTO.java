package com.hexaware.assetmanagement.dto;

public class AssetCategoryDTO {
	private int categoryId;
    private String categoryName;

    // Constructors
    public AssetCategoryDTO() {
        // Default constructor
    }

    public AssetCategoryDTO(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "AssetCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
}