package com.example.bank.bankapp;

import com.example.bank.bankapp.dao.BankAccountDAO;
import com.example.bank.bankapp.model.BankAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class BankAccountDAOTest {
	
	@Autowired
	// allows Spring to inject required beans into the test class - we do not need to instantiate BankAccountDAO
	// manually 
	public BankAccountDAO bankAccountDAO;
	
	@Test
	void testCreateBankAccount() {
		
	}
}