package com.example.bank.bankapp.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	// Hash password
	public static String hashPassword(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	}
	// Verify if entered password matches hash
	public static boolean verifyPassword(String candidate, String hashedPassword) {
		return BCrypt.checkpw(candidate, hashedPassword);
	}
}