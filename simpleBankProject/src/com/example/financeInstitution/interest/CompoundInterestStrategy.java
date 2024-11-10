package interest;
import account.InterestBearing;

public class CompoundInterestStrategy implements InterestBearing{
    private double rate;

    public CompoundInterestStrategy(double rate) {
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
        // calculate interest for a single compounding period
        return balance * Math.pow(1 + this.rate / 12, (1 / 12) * 12) - balance;
    }
    @Override
    public double calculateYearlyYield(double balance) {
        // calculate interest compounded over a full year
        return balance * Math.pow(1 + this.rate / 12, 12) - balance;
    }
}
