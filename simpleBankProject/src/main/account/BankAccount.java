package main.account;
import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;

    // Strategy pattern: Interfaces for interest calculation and Overdraft
    private InterestBearing interestStrategy;
    private OverdraftProtection overdraftProtection;

    public BankAccount(String accountNumber, String accountName, String accountType, String currency, String accountStatus, float accountBalance)
}
