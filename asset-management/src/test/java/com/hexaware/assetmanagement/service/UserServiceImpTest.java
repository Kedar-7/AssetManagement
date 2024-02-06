package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.assetmanagement.dto.UserDTO;
import com.hexaware.assetmanagement.entities.Asset;
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

		List<User> userList = service.getAllUsers();
        assertFalse(userList.isEmpty());
		
	}

	@Test
	void testGetUserById() {
		UserDTO users = service.getUserById(2);
		assertEquals("priya_sharma", users.getUsername());

	}

	@Test
	void testDeleteUserById() {
		int userId = 3;
        String result = service.deleteUserById(userId);
        assertNotNull(result);
        assertEquals("Record Deleted", result);
		
	}

}
