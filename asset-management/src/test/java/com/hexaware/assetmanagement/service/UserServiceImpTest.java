package com.hexaware.assetmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
//		User users = service.getUserById(2);
//		assertEquals("Aman", users.getUsername());
		
		User users = service.getUserById(2);
		assertEquals("priya_sharma", users.getUsername());

	}

	@Test
	void testDeleteUserById() {
//		User user = new User();
//		int id = 5;
//		String count = service.deleteUserById(id);
//		assertEquals(id, user.getUserId());
		int userId = 3;
        String result = service.deleteUserById(userId);
        assertNotNull(result);
        assertEquals("Record Deleted", result);
		
	}

}
