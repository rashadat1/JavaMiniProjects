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
	public Long getId() {
		return this.id;
	}
	public Long getUserId() {
		return this.user_id;
	}
	public String getAccountNumber() {
		return this.account_number;
	}
	public BigDecimal getBalance() {
		return this.balance;
	}
	public BigDecimal getInterestRate() {
		return this.interest_rate;
	}
	public String getAccountType() {
		return this.account_type;
	}
	public LocalDateTime getCreatedAt() {
		return this.created_at;
	}
	public BigDecimal getOverdraftLimit() {
		return this.overdraft_limit;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long id) {
		this.user_id = id;
	}
	public void setAccountNumber(String account_number) {
		this.account_number = account_number;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public void setInterestRate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}
	public void setAccountType(String account_type) {
		this.account_type = account_type;
	}
	public void setCreatedAt(LocalDateTime timestamp) {
		this.created_at = timestamp;
	}
	public void setOverdraftLimit(BigDecimal overdraft_limit) {
		this.overdraft_limit = overdraft_limit;
	}
	@Override
	public String toString() {
	    return "BankAccount{" +
	            "id=" + id +
	            ", user_id=" + user_id +
	            ", account_number='" + account_number + '\'' +
	            ", balance=" + balance +
	            ", interest_rate=" + interest_rate +
	            ", account_type='" + account_type + '\'' +
	            ", created_at=" + created_at +
	            ", overdraft_limit=" + overdraft_limit +
	            '}';
	}

}





