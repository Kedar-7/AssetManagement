package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.repository.UserRepository;


@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User addUsers(User users) {
		return repo.save(users);
	}

	@Override
	public User updateUsers(User users) {
		return repo.save(users);
	}

	@Override
	public User getUserById(int userId) {
		return repo.findById(userId).orElse(null);
	}

	@Override
	public String deleteUserById(int userId) {
		repo.deleteById(userId);
		return "Record Deleted";
	}

}
