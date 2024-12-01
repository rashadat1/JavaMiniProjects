package com.example.bank.bankapp.model;

import java.time.LocalDateTime;

public class User {
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDateTime created_at;
    private Long role_id;

    // we create an empty constructor so that the framework can instantiate the object
    // and set fields based on database query results
    public User() {

    }
    public User(Long user_id, String name, String email, String password, String phone_number, LocalDateTime created_at, Long role_id) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.role_id = role_id;
    }
    public Long getId() {
    	return this.user_id;
    }
    public String getName() {
    	return this.name;
    }
    public String getEmail() {
    	return this.email;
    }
    public String getPassword() {
    	return this.password;
    }
    public String getPhoneNumber() {
    	return this.phone_number;
    }
    public LocalDateTime getCreatedAt() {
    	return this.created_at;
    }
    public Long getRole() {
    	return this.role_id;
    }
	public void setId(Long id) {
		this.user_id = id;
	}
    
    public void setName(String name) {
    	this.name = name;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setPhoneNumber(String phone_number) {
    	this.phone_number = phone_number;
    }
    public void setCreatedAt(LocalDateTime timestamp) {
    	this.created_at = timestamp;
    }
    public void setRoleId(Long roleId) {
    	this.role_id = roleId;
    }
    @Override
    public String toString() {
    	return "Users{" +
    			"user_id=" + this.user_id +
    			", name=" + this.name +
    			", email=" + this.email +
    			", phoneNumber=" + this.phone_number +
    			", createdAt=" + this.created_at +
    			", roleId=" + this.role_id + 
    			'}';
    }
}