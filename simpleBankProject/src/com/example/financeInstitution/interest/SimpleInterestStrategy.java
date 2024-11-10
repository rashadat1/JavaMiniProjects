package interest;
import account.InterestBearing;

public class SimpleInterestStrategy implements InterestBearing {
    private double rate;

    public SimpleInterestStrategy(double rate) {
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
    public double calculateYearlyYield(double balance) {
        return balance * this.rate;
    }
    @Override
    public double calculateInterest(double balance) {
        return calculateYearlyYield(balance) / 12;
    }

}