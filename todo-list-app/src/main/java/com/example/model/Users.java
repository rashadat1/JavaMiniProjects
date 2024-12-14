package com.example.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Users {
	// Id marks primary key of table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private LocalDateTime created_at = LocalDateTime.now();
	
	public Users() {
		
	}
	public Users(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	// Getters and Setters
	
}