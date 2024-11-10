package overdraft;
import account.OverdraftProtection;

public class FlexibleOverdraftProtection implements OverdraftProtection{
    private final double maxOverdraftPercentage;
    private final double overdraftFeeRate;
    
    public FlexibleOverdraftProtection(double maxOverdraftPercentage, double overdraftFeeRate) {
        this.maxOverdraftPercentage = maxOverdraftPercentage;
        this.overdraftFeeRate = overdraftFeeRate;
    }
    @Override
    public boolean canWithdraw(double amount, double balance) {
        double overdraftLimit = balance * this.maxOverdraftPercentage;
        return balance + overdraftLimit >= amount;
    }
    @Override
    public double calculateOverdraftFee(double amount, double balance) {
        double overdraftLimit = balance * this.maxOverdraftPercentage;
        if (amount > overdraftLimit + balance) {
            return this.overdraftFeeRate * (amount - (overdraftLimit + balance));
        }
        return 0.0;
    }
    @Override
    public double getOverdraftLimit() {
        return this.maxOverdraftPercentage;
    }
    @Override
    public double getOverdraftFeeRate() {
        return this.overdraftFeeRate;
    }
}