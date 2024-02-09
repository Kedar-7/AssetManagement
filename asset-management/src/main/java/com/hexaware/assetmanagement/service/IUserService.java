package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.User;

public interface IUserService {
	public List<User> getAllUsers();
	public User addUsers(UserDTO userDTO);
	public User updateUsers(User users);
	public User getUserById(int userId);
	public String deleteUserById(int userId);
}
