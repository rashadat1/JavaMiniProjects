package account;
import java.time.LocalDateTime;

/*
in general we would create setters to modify the fields of
an object after it has been created

Transactions are immutable so we do not need to provide setters
Getters for read-only access and using private fields ensures the class is immutable
*/
public class Transaction {
    // once these values are set in the constructor they cannot be changed
    private final double amount;
    private final LocalDateTime timestamp;
    private final String category;
    private final String description;

    public Transaction(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    // transaction data getters 
    // no setters so each transaction instance is immutable
    public double getAmount() {
        return this.amount;
    }                                                    

    public LocalDateTime getTimeStamp() {
        return this.timestamp;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }
}