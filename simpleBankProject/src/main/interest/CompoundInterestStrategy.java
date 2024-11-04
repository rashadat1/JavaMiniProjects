package interest;
import account.InterestBearing;

public class CompoundInterestStrategy implements InterestBearing{
    private double rate;
    private final int numPeriods;

    public CompoundInterestStrategy(double rate, int numPeriods) {
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
        // calculate interest for a single compounding period
        return balance * Math.pow(1 + this.rate / this.numPeriods, 1) - balance;
    }
    @Override
    public double calculateYearlyYield(double balance) {
        // calculate interest compounded over a full year
        return balance * Math.pow(1 + this.rate / this.numPeriods, this.numPeriods) - balance;
    }
    public int getNumPeriods() {
        return this.numPeriods;
    }

}
