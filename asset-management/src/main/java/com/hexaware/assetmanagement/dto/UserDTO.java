package com.hexaware.assetmanagement.dto;

public class UserDTO {

	private int userid;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String contactnumber;
	private String address;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserDTO(int userid, String username, String password, String name, String gender, String contactnumber,
			String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.contactnumber = contactnumber;
		this.address = address;
	}
	public UserDTO() {
		super();
	}
	
	
	
}
