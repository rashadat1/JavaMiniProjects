package overdraft;
import account.OverdraftProtection;

public class BasicOverdraftProtection implements OverdraftProtection {
    private final double overdraftLimit;
    private final double overdraftFeeRate;

    public BasicOverdraftProtection(double overdraftLimit, double overdraftFeeRate) {
        this.overdraftLimit = overdraftLimit;
        this.overdraftFeeRate = overdraftFeeRate;
    }
    @Override
    public boolean canWithdraw(double amount, double balance) {
        // in the case that the amount exceeds the balance
        // we can still withdraw if it is within the overdraftLimit
        return balance + this.overdraftLimit >= amount;
    }
    @Override
    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }
    @Override
    public double getOverdraftFeeRate() {
        return this.overdraftFeeRate;
    }
    @Override
    public double calculateOverdraftFee(double amount, double balance) {
        if (amount > this.overdraftLimit + balance) {
            return overdraftFeeRate * (amount - (this.overdraftLimit + balance));
        }
        return 0.0;
    }
}
