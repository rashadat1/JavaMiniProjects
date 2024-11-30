package com.example.bank.bankapp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component // allow spring to manage this as a bean
public class DatabaseConnection {
	@Value("${spring.datasource.url}")
	private String URL;
	@Value("${spring.datasource.username}")
	private String USER;
	@Value("${spring.datasource.password}")
	private String PASSWORD;
	
	private Connection connection = null;
	
	// Method to establish and return a connection
	public Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Database connection successfully established!");
				System.out.println("Connected to url: " + URL);
			} catch (SQLException e) {
				System.out.println("Failed to connect to the database.");
				throw e;
			}
		}
		return connection;
	}
	// Method to close the connection
	public void closeConnection() {
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