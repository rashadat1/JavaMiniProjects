package account;
public interface InterestBearing {
    double calculateInterest(double balance);
    void setInterestRate(double rate);
    double getInterestRate();
    double calculateYearlyYield(double balance);
}
