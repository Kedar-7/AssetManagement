package com.hexaware.assetmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRole {
	
	@Id
	@Column(name = "RoleID")
	private int roleId;
	@Column(name = "RoleName")
    private String roleName;
	public UserRole() {
		super();
	}
	public UserRole(int roleId, String roleName) {
		super();
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