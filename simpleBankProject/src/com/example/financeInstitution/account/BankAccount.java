package account;
import java.util.ArrayList;
import java.util.List;
import observer.AccountObserver;
import utils.EventType;

// Creates all of the bank account logic as methods of a bank account class
public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private final List<Transaction> transactions;
    private final List<AccountObserver> observers;

    private final OverdraftProtection overdraftStrategy;
    private final InterestBearing interestStrategy;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, OverdraftProtection overdraftStrategy, InterestBearing interestStrategy) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.overdraftStrategy = overdraftStrategy;
        this.interestStrategy = interestStrategy;

        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    // Method to add an observer to the ArrayList
    public void addObserver(AccountObserver observer) {
        this.observers.add(observer);
    }
    // Method to remove an observer from the ArrayList
    public void removeObserver(AccountObserver observer) {
        this.observers.remove(observer);
    }
    // Method to notify observers based on event Type
    public void notifyObserver(String message, EventType eventType) {
        for (AccountObserver observer : this.observers) {
            observer.update(eventType, message);
        }
    }
    // Method for deposits
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactions.add(new Transaction(amount, "Deposit", "Deposited funds"));
            System.out.println("Deposited $" + amount);
            this.notifyObserver("Deposit of $" + amount + " made into account " + this.accountNumber, EventType.TRANSACTION_EVENT);
        } else {
            System.out.println("Amount to deposit must be greater than 0");
        }
    }
    // Method for withdrawals
    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                this.transactions.add(new Transaction(amount, "Withdrawal", "Withdrew funds"));
                System.out.println("Withdrew $" + amount);
                this.notifyObserver("Withdrawal of $" + amount + " journaled from account " + this.accountNumber, EventType.TRANSACTION_EVENT);
            } else if (this.overdraftStrategy != null && this.overdraftStrategy.canWithdraw(amount, this.balance)) {
                double overdraftFee = this.overdraftStrategy.calculateOverdraftFee(amount, this.balance);
                balance -= (amount + overdraftFee);
                this.transactions.add(new Transaction(-amount, "Withdrawal", "Withdrew funds using overdraft protection"));
                System.out.println("Withdrew $" + amount + " with an overdraft fee of $" + overdraftFee);
                this.notifyObserver("Overdraft occurred from withdrawal of $" + amount, EventType.OVERDRAFT_EVENT);
            } else {
                // if there is no overdraft protection or it is insufficient to withdraw funds
                System.out.println("Insufficient funds for a withdrawal of $" + amount);
                this.notifyObserver("Failed Withdrawal attempt because of insufficient funds and overdraft limit on account " + this.accountNumber, EventType.FAILED_WITHDRAWAL_EVENT);
            }
        } else {
            System.out.println("Amount to withdraw must be greater than 0");
        }
    }
    // Method to obtain interest accrued for one period (1 month)
    public void applyInterest() {
        // notice that rate is an attribute of each implementation of the interestStrategy
        // they encapsulate the rate - the rate is handled internally
        double interest = this.interestStrategy.calculateInterest(balance);
        this.transactions.add(new Transaction(interest, "Interest", "Interest applied"));
        System.out.println("Applied interest: $" + interest);
        this.notifyObserver("Interest of $" + interest + " applied to account " + this.accountNumber, EventType.TRANSACTION_EVENT);
    }
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber + ":");
        for (Transaction transaction : transactions) {
            System.out.println("Amount: " + transaction.getAmount() +
                            ", Timestamp: " + transaction.getTimeStamp() +
                            ", Category: " + transaction.getCategory() +
                            ", Description: " + transaction.getDescription());
        }
    }
    // Getters for bank account attributes
    public double getBalance() {
        return this.balance;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
}