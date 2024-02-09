package com.hexaware.assetmanagement.dto;

public class UserRoleDTO {
	private int roleId;
    private String roleName;

    // Constructors
    public UserRoleDTO() {
        // Default constructor
    }

    public UserRoleDTO(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}