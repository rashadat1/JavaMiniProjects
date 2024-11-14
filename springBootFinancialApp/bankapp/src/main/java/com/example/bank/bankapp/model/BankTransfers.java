package com.example.bank.bankapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankTransfers {
    private Long id;
    private Long sender_account_id;
    private Long receiver_account_id;
    private BigDecimal amount;
    private LocalDateTime transfer_date;
    private String description;

    public BankTransfers() {

    }
    public BankTransfers(Long id, Long sender_account_id, Long receiver_account_id, BigDecimal amount, LocalDateTime transfer_date, String description) {
        this.id = id;
        this.sender_account_id = sender_account_id;
        this.receiver_account_id = receiver_account_id;
        this.amount = amount;
        this.transfer_date = transfer_date;
        this.description = description;
    }
    public Long getId() {
        return this.id;
    }
    public Long getSenderId() {
        return this.sender_account_id;
    }
    public Long getReceiverId() {
        return this.receiver_account_id;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    public LocalDateTime getTransferDate() {
        return this.transfer_date;
    }
    public String getDescription() {
        return this.description;
    }
    public void setSenderId(Long id) {
    	this.sender_account_id = id;
    }
    public void setReceiverId(Long id) {
    	this.receiver_account_id = id;
    }
    public void setAmount(BigDecimal amount) {
    	this.amount = amount;
    }
    public void setTransferDate(LocalDateTime dateTime) {
    	this.transfer_date = dateTime;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    @Override
    public String toString() {
        return "BankTransfers{" +
                "id=" + id +
                ", sender_account_id=" + sender_account_id +
                ", receiver_account_id=" + receiver_account_id +
                ", amount=" + amount +
                ", transfer_date=" + transfer_date +
                ", description='" + description + '\'' +
                '}';
    }
    
}
