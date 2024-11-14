package com.example.bank.bankapp;

import com.example.bank.bankapp.util.DatabaseConnection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Profile("test")
class DatabaseConnectionTests {
	@Test
	void testDatabaseConnection() {
		try (Connection connection = DatabaseConnection.getConnection()) {
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