package com.example.bank.bankapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:postgresql://localhost:5431/financeInstitution";
	private static final String USER = System.getenv("DB_USER");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");
	private static Connection connection = null;
	
	// Method to establish and return a connection
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Database connection successfully established!");
			} catch (SQLException e) {
				System.out.println("Failed to connect to the database.");
				throw e;
			}
		}
		return connection;
	}
	// Method to close the connection
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Database connection closed.");
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection.");
			}
		}
	}
}