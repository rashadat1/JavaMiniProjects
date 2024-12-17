package com.example.repository;

import com.example.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
	// Custom method to get all ToDos for a singlue user
	// query automatically generated - SELECT * FROM ToDoList WHERE user_id = ?
	List<ToDoList> FindByUserId(Long userId);
}