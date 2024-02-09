package com.hexaware.assetmanagement.dto;

public class UserDTO {
	private int userId;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String contactNumber;
    private String address;
    
    public UserDTO() {
        // Default constructor
    }
    
	public UserDTO(int userId, String username, String password, String name, String gender, String contactNumber,
			String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}
	
}