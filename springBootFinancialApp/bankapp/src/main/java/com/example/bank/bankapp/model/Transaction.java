package com.example.bank.bankapp.model;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Transaction {
	private Long id;
	private Long bank_account_id;
	private BigDecimal amount;
	private String category;
	private String description;
	private String transaction_type;
	private LocalDateTime timestamp;
	private String transaction_status;
	
	public Transaction() {
		
	}
	public Transaction(Long id, Long bank_account_id, BigDecimal amount, String category, String description, String transaction_type, LocalDateTime timestamp, String transaction_status) {
		this.id = id;
		this.bank_account_id = bank_account_id;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.transaction_type = transaction_type;
		this.timestamp = timestamp;
		this.transaction_status = transaction_status;
	}
	public Long getId() {
		return this.id;
	}
	public Long getBankAccountId() {
		return this.bank_account_id;
	}
	public BigDecimal getAmount() {
		return this.amount;
	}
	public String getCategory() {
		return this.category;
	}
	public String getDescription() {
		return this.description;
	}
	public String getTransactionType() {
		return this.transaction_type;
	}
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}
	public String getTransactionStatus() {
		return this.transaction_status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBankAccountId(Long bank_account_id) {
		this.bank_account_id = bank_account_id;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTransactionType(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public void setTransactionStatus(String status) {
		this.transaction_status = status;
	}
	@Override
	public String toString() {
	    return "Transaction{" +
	            "id=" + id +
	            ", bank_account_id=" + bank_account_id +
	            ", amount=" + amount +
	            ", category='" + category + '\'' +
	            ", description='" + description + '\'' +
	            ", transaction_type='" + transaction_type + '\'' +
	            ", timestamp=" + timestamp +
	            ", transaction_status='" + transaction_status + '\'' +
	            '}';
	}
}



