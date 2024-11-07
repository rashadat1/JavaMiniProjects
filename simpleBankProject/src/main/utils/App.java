package utils;
import account.BankAccount;
import interest.SimpleInterestStrategy;
import overdraft.BasicOverdraftProtection;

public class App {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(
            "12345",
            "Alice",
            1000,
            new BasicOverdraftProtection(500, 0.1),
            new SimpleInterestStrategy(0.03)
        );
    }
}
