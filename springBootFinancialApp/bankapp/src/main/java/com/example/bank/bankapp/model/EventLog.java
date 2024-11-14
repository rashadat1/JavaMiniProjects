package com.example.bank.bankapp.model;

import java.time.LocalDateTime;

public class EventLog {
	private Long id;
	private Long bank_account_id;
	private String event_type;
	private String event_message;
	private LocalDateTime timestamp;
	private Long transaction_id;
	
	public EventLog() {
		
	}
	public EventLog(Long id, Long bank_account_id, String event_type, String event_message, LocalDateTime timestamp, Long transaction_id) {
		this.id = id;
		this.bank_account_id = bank_account_id;
		this.event_type = event_type;
		this.event_message = event_message;
		this.timestamp = timestamp;
		this.transaction_id = transaction_id;
	}
	public Long getId() {
		return this.id;
	}
	public Long getBankAccountId() {
		return this.bank_account_id;
	}
	public String getEventType() {
		return this.event_type;
	}
	public String getEventMessage() {
		return this.event_message;
	}
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}
	public Long getTransactionId() {
		return this.transaction_id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBankAccountId(Long bank_account_id) {
		this.bank_account_id = bank_account_id;
	}
	public void setEventType(String event_type) {
		this.event_type = event_type;
	}
	public void setEventMessage(String event_message) {
		this.event_message = event_message;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public void setTransactionId(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Override
	public String toString() {
	    return "EventLog{" +
	            "id=" + id +
	            ", bank_account_id=" + bank_account_id +
	            ", event_type='" + event_type + '\'' +
	            ", event_message='" + event_message + '\'' +
	            ", timestamp=" + timestamp +
	            ", transaction_id=" + transaction_id +
	            '}';
	}

}