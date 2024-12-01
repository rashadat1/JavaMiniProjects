package com.example.bank.bankapp.dao;

import com.example.bank.bankapp.model.User;
import com.example.bank.bankapp.util.PasswordUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {
	private final JdbcTemplate jdbcTemplate;
	
	// Constructor-based dependency injection
	public UserDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// CRUD Operations
	// CREATE a new User
	public boolean createUser(User user) throws SQLException {
		// omit setting the userID because the data will handle this as a serial field
		String sql = "INSERT INTO users (name, email, password, phone_number, role_id) VALUES (?, ?, ?, ?, ?)";
		String hashedPassword = PasswordUtil.hashPassword(user.getPassword()); // hash the password
		System.out.println("Database URL: " + jdbcTemplate.getDataSource().getConnection().getMetaData().getURL());
		System.out.println("Database User: " + jdbcTemplate.getDataSource().getConnection().getMetaData().getUserName());
		int rowsInserted = jdbcTemplate.update(
				sql,
				user.getName(),
				user.getEmail(),
				hashedPassword,
				user.getPhoneNumber(),
				user.getRole()
		);
		return rowsInserted > 0;
	}
	// (READ) Find a User by Id
	public User findUserById(Long id) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
	}
	// (READ) Find a User by email
	public User findUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
	}
	// (READ) Retrieve a User's role
	public String getUserRole(Long userId) {
		String sql = "SELECT r.name FROM roles r INNER JOIN users u ON r.id = u.role_id WHERE u.user_id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, userId);
	}
	// (UPDATE) Update User data
	public boolean updateUserData(User user) {
		String sql = "UPDATE users SET name = ?, phone_number = ?, email = ? WHERE user_id = ?";
		int rowsUpdated = jdbcTemplate.update(
				sql,
				user.getName(),
				user.getPhoneNumber(),
				user.getEmail(),
				user.getId()
		);
		return rowsUpdated > 0;
	}
	// DELETE a User by ID
	public boolean deleteUserById(Long id) {
		String sql = "DELETE FROM users WHERE user_id = ?";
		int rowsDeleted = jdbcTemplate.update(sql, id);
		return rowsDeleted > 0;
	}
	
	// Authenticate User
	public boolean authenticateUser(String email, String candidatePassword) {
		User user = this.findUserByEmail(email);
		if (user == null) {
			return false;
		}
		String hashedPassword = user.getPassword();
		boolean isMatch = PasswordUtil.verifyPassword(candidatePassword, hashedPassword);
		return isMatch;
	}
	
	// RowMapper to map ResultSet rows to User objects after a query
	private static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet resultSet, int RowNum) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setName(resultSet.getString("name"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setPhoneNumber(resultSet.getString("phone_number"));
			user.setRoleId(resultSet.getLong("role_id"));
			
			java.sql.Timestamp timestamp = resultSet.getTimestamp("created_at");
			if (timestamp != null) {
				user.setCreatedAt(timestamp.toLocalDateTime());
			}
			return user;
		}
	}
}
