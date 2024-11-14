package com.example.bank.bankapp.model;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class BankAccount {
	private Long id;
	private Long user_id;
	private String account_number;
	private BigDecimal balance;
	private BigDecimal interest_rate;
	private String account_type;
	private LocalDateTime created_at;
	private BigDecimal overdraft_limit;
	
	public BankAccount() {
		
	}
	public BankAccount(Long id, Long user_id, String account_number, BigDecimal balance, BigDecimal interest_rate, String account_type, LocalDateTime created_at, BigDecimal overdraft_limit) {
		this.id = id;
		this.user_id = user_id;
		this.account_number = account_number;
		this.balance = balance;
		this.interest_rate = interest_rate;
		this.account_type = account_type;
		this.created_at = created_at;
		this.overdraft_limit = overdraft_limit;
	}
	// Getters, Setters, and toString() method 
}