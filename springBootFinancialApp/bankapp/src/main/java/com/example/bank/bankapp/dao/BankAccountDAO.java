package com.example.bank.bankapp.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.example.bank.bankapp.model.BankAccount;

@Repository
public class BankAccountDAO {
	private final JdbcTemplate jdbcTemplate;
	private final UserDAO userDAO; // Add UserDAO as a dependency to use its methods
	
	public BankAccountDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.userDAO = userDAO;
	}
	// CRUD Operations
	// CREATE a new Bank Account
	public boolean createAccount(BankAccount account) throws SQLException {
		String sql = "INSERT INTO bank_account (user_id, account_number, balance, interest_rate, account_type, overdraft_limit) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
		int rowsInserted = jdbcTemplate.update(
				sql,
				account.getUserId(),
				account.getAccountNumber(),
				account.getBalance(),
				account.getInterestRate(),
				account.getAccountType(),
				account.getOverdraftLimit()
		);
		return rowsInserted > 0;
		
	}
	// (READ) Find an account by Id
	public BankAccount findAccountById(Long id) {
		String sql = "SELECT * FROM bank_account WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BankAccountRowMapper(), id);
	}
	// (READ) Find an account by account number
	public BankAccount findAccountByNumber(BigDecimal account_number) {
		String sql = "SELECT * FROM bank_account WHERE account_number = ?";
		return jdbcTemplate.queryForObject(sql, new BankAccountRowMapper(), account_number);
	}
	// (READ) Find all accounts for a particular user
	public List<BankAccount> findAllAccountForUser(Long user_id) {
		// Spring internally uses an ArrayList to store the result
		// specify List<BankAccount> to follow principle of coding to an interface this allows the implementation
		// to be changed to LinkedList for instance
		String sql = "SELECT * FROM bank_account WHERE user_id = ?";
		return jdbcTemplate.query(sql, new BankAccountRowMapper(), new Object[] { user_id });
	}
	// Update a bank account's balance
	public boolean updateAccountBalance(Long id, BigDecimal newbalance) {
		String sql = "UPDATE bank_account SET balance = ? WHERE id = ?";
		int rowsUpdated = jdbcTemplate.update(sql, newbalance, id);
		return rowsUpdated > 0;
	}
	// Update the interest rate for bank account
	public boolean updateInterestRate(Long accountId, BigDecimal newInterestRate, Long userId) {
		// check if userId has ADMIN permissions - required to update interest rates
		String userRole = userDAO.getUserRole(userId); // use injected userDAO
		if (!"ADMIN".equals(userRole)) {
			throw new SecurityException("You do not have permissions to update the interest rate");
		}
		String sql = "UPDATE bank_account SET interest_rate = ? WHERE id = ?";
		int rowsUpdated = jdbcTemplate.update(sql, newInterestRate, accountId);
		return rowsUpdated > 0;
	}
	// Update the overdraft limit for a bank account
	public boolean updateOverdraftLimit(Long accountId, BigDecimal newOverdraftLimit, Long userId) {
		String userRole = userDAO.getUserRole(userId);
		if (!"ADMIN".equals(userRole)) {
			throw new SecurityException("You do not have permissions to update the overdraft limit");
		}
		String sql = "UPDATE bank_account SET overdraft_limit = ? WHERE id = ?";
		int rowsUpdated = jdbcTemplate.update(sql, newOverdraftLimit, accountId);
		return rowsUpdated > 0;
	}
	// Delete bank account by ID
	public boolean deleteAccountById(Long id) {
		String sql = "DELETE FROM bank_accounts WHERE id = ?";
		int rowsDeleted = jdbcTemplate.update(sql,id);
		return rowsDeleted > 0;
	}
	// Delete all accounts for a user
	public boolean deleteAllAccountsForUser(Long user_id) {
		String sql = "DELETE FROM bank_accounts WHERE user_id = ?";
		int rowsDeleted = jdbcTemplate.update(sql, user_id);
		return rowsDeleted > 0;
	}
	// RowMapper for mapping ResultSet rows to BankAccount objects
	private static class BankAccountRowMapper implements RowMapper<BankAccount> {
		@Override
		// mapRow method is called once for each row in the ResultSet by the jdbcTemplate.query() method
		// each call creates a BankAccount object and they are collected into a List
		public BankAccount mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setId(resultSet.getLong("id"));
			bankAccount.setUserId(resultSet.getLong("user_id"));
			bankAccount.setAccountNumber(resultSet.getString("account_number"));
			bankAccount.setBalance(resultSet.getBigDecimal("balance"));
			bankAccount.setInterestRate(resultSet.getBigDecimal("interest_rate"));
			bankAccount.setOverdraftLimit(resultSet.getBigDecimal("overdraft_limit"));
			bankAccount.setAccountType(resultSet.getString("account_type"));
			
			java.sql.Timestamp timestamp = resultSet.getTimestamp("created_at");
			if (timestamp != null) {
				bankAccount.setCreatedAt(timestamp.toLocalDateTime()); 
			}
			return bankAccount;
		}
	}
}