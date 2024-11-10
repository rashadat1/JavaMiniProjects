package interest;
import account.InterestBearing;

public class ContinuousInterestStrategy implements InterestBearing{
    private double rate;

    public ContinuousInterestStrategy(double rate) {
        this.rate = rate;

    }
    @Override
    public void setInterestRate(double rate) {
        this.rate = rate;
    }
    @Override
    public double getInterestRate() {
        return this.rate;
    }
    @Override
    public double calculateInterest(double balance) {
        // Calculate interest for one period
        return balance * Math.exp(this.rate / 12) - balance;
    }
    @Override
    public double calculateYearlyYield(double balance) {
        return balance * Math.exp(this.rate) - balance;
    }
}
