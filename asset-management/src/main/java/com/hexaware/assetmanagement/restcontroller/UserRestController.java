package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.service.IUserService;
import com.hexaware.userrest.exception.ProductNotFoundException;
import com.hexaware.assetmanagement.dto.UserDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	
	@Autowired
	IUserService service;

	@PostMapping("/add")
	public User adduser(@RequestBody UserDTO UserDTO) {

		return service.addUser(UserDTO);
	}

	@GetMapping("/get/{uid}")
	public UserDTO getById(@PathVariable int uid) {
		
		UserDTO userDTO = service.getUserById(uid);

		if (userDTO.getUserid() == 0) {

			throw new ProductNotFoundException(HttpStatus.BAD_REQUEST, "Product Not Found for Pid : " + uid);
		}

		return userDTO;
	}

	@GetMapping("/getall")
	public List<User> getAllusers() {
		
		return service.getAllUsers();
	}


	
	@DeleteMapping("/delete/{uid}")
	public String deleteById(@PathVariable int uid) {
		
		return service.deleteUserById(uid);
		
	}

}
