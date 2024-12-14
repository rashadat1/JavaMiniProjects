package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = true)
	@Lob
	private String description;
	
	@Column(nullable = false)
	private Boolean completed = false;
	
	@Column(nullable = false)
	private LocalDateTime created_at = LocalDateTime.now();
	
	@Column(nullable = true)
	private LocalDateTime due_date;
	
	public ToDoList() {
		
	}
	public ToDoList(Users user, String title, String description, Boolean completed, LocalDateTime due_date) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.due_date = due_date;
	}
	
	// Getters and Setters
	
}