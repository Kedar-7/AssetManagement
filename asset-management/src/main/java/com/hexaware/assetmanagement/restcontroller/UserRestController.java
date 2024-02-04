package com.hexaware.assetmanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.assetmanagement.entities.User;
import com.hexaware.assetmanagement.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User addUsers(@RequestBody User users) {
		return service.addUsers(users);
	}
	
	@GetMapping("/getall")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		return service.deleteUserById(userId);
	}
	
	
	@PutMapping("/update")
	public User updateUsers(@PathVariable User users) {
		return service.updateUsers(users);
	}
	
	@GetMapping("/getbyid/{userId}")
	public User getUserById(int userId) {
		return service.getUserById(userId);
	}
}
