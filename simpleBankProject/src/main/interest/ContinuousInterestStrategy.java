package interest;
import account.InterestBearing;

public class ContinuousInterestStrategy implements InterestBearing{
    private double rate;
    private final int numPeriods;

    public ContinuousInterestStrategy(double rate, int numPeriods) {
        this.rate = rate;
        this.numPeriods = numPeriods;

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
        return balance * Math.exp(this.rate / this.numPeriods) - balance;
    }
    @Override
    public double calculateYearlyYield(double balance) {
        return balance * Math.exp(this.rate) - balance;
    }
    public int getNumPeriods() {
        return this.numPeriods;
    }
}
