package account;
public interface OverdraftProtection {
    boolean canWithdraw(double amount, double balance);
    double getOverdraftLimit();
    double getOverdraftFeeRate();
    double calculateOverdraftFee(double amount, double balance);
}
