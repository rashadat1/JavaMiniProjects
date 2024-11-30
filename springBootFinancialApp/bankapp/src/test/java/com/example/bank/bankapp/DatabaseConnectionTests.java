package com.example.bank.bankapp;

import com.example.bank.bankapp.util.DatabaseConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// tells SpringBoot to load entire application context to make this an integration test
@SpringBootTest
@ActiveProfiles("test")
class DatabaseConnectionTests {
	
	@Autowired
	private DatabaseConnection databaseConnection; // inject DatabaseConnection bean
	@Test
	void testDatabaseConnection() {
		try (Connection connection = databaseConnection.getConnection()) {
			// Verify that the connection is not null
			assertNotNull(connection, "Database connection should not be null");
			
			// Check that the connection is valid
			assertTrue(connection.isValid(2),"Database connection should be valid");
			System.out.println("Database connection test passed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}