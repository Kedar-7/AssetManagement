package com.hexaware.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImp implements IUserService{


	@Autowired
	UserRepository repo;
	


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}



	@Override
	public String deleteUserById(int uid) {
		repo.deleteById(uid);
		 return "Record Deleted";
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User addUser(UserDTO userDTO) {
		User user= new User(); 
		
		user.setAddress(userDTO.getAddress());
		user.setContactNumber(userDTO.getContactnumber());
		user.setGender(userDTO.getGender());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserid());
		user.setUsername(userDTO.getUsername());

		return repo.save(user);
	}



	@Override
	public UserDTO getUserById(int uid) {
		
		User user= repo.findById(uid).orElse(new User());
		

		

		UserDTO userDTO = new UserDTO();

		userDTO.setAddress(user.getAddress());
		userDTO.setContactnumber(user.getContactNumber());
		userDTO.setGender(user.getGender());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setUserid(user.getUserId());
		userDTO.setUsername(user.getUsername());

		
		return  userDTO;
				
	}




}
