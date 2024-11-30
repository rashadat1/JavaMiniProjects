package com.example.bank.bankapp;

import com.example.bank.bankapp.dao.UserDAO;
import com.example.bank.bankapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

@SpringBootTest // Load full application context
@ActiveProfiles("test") // to use application-test.properties for configuration
@Transactional // ensure any database changes are rolled back after the test completes
class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	void testCreateAndFindUser() throws SQLException {
		// Create a new user and then find it in the test database
		User user = new User();
		user.setName("Bob Smith");
		user.setEmail("bob.smith@example.com");
		user.setPassword("Password123");
		user.setPhoneNumber("1112223456");
		
		// Act: Insert the user into the database
		boolean isCreated = userDAO.createUser(user);
		assertTrue(isCreated, "User should be created successfully");
		// Act: Retrieve the user by email
		User retrievedUser = userDAO.findUserByEmail("bob.smith@example.com");
		
		// Assert: Verify the retrieved user's details
		assertNotNull(retrievedUser, "User should be found");
		assertEquals("Bob Smith", retrievedUser.getName(), "Names should be a match");
		assertEquals("bob.smith@example.com", retrievedUser.getEmail(), "Emails should be a match");
		assertNotNull(retrievedUser.getCreatedAt(), "Created at timestamp should not be null");
		
	}
	
	@Test
	void testAuthentication() throws SQLException {
		// Create a new user
		User user = new User();
		user.setName("Alice Stewart");
		user.setEmail("alice.stewart@example.com");
		user.setPassword("Password246");
		user.setPhoneNumber("1234567890");
		
		// Act: Insert the user into the database
		boolean isCreated = userDAO.createUser(user);
		assertTrue(isCreated, "User should be created successfully");
		// Act: Authenticate user login
		boolean isAuthenticated = userDAO.authenticateUser("alice.stewart@example.com", "Password246");
		assertTrue(isAuthenticated, "User should be authenticated successfully");
		// Act: Authenticate with incorrect password
		boolean isNotAuthenticated = userDAO.authenticateUser("alice.stewart@example.com", "IncorrectPassword");
		assertFalse(isNotAuthenticated, "User should not be authenticated");
	}
	
}