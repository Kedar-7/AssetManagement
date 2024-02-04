package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.User;



public interface IUserService {

	public User addUser(UserDTO userDTO);

	public User updateUser(User User);

	public UserDTO getUserById(int eid);

	public String deleteUserById(int eid);
	
	public  List<User>  getAllUsers();


	
}
