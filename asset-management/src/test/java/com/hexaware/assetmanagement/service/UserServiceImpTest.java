package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.User;

@SpringBootTest
class UserServiceImpTest {

	@Autowired
	IUserService service;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetAllUsers() {
		List list = service.getAllUsers();
		boolean flag = list.isEmpty();
		assertFalse(flag);
		
	}

	@Test
	void testGetUserById() {
		UserDTO users = service.getUserById(2);
		assertEquals("Aman", users.getUsername());

	}

	@Test
	void testDeleteUserById() {
		User user = new User();
		int id = 5;
		String count = service.deleteUserById(id);
		assertEquals(id, user.getUserId());
		
	}

}
