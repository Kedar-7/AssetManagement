package com.hexaware.assetmanagement.service;

import java.util.List;

import com.hexaware.assetmanagement.entities.User;

public interface IUserService {
	public List<User> getAllUsers();
	public User addUsers(User users);
	public User updateUsers(User users);
	public User getUserById(int userId);
	public String deleteUserById(int userId);
}
