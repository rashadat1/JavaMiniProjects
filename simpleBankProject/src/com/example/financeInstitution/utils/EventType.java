package utils;
public enum EventType {
    TRANSACTION_EVENT, // for deposits, withdrawals, and interest 
    BALANCE_ALERT, // low balance warnings
    OVERDRAFT_EVENT, // notification when overdraft is triggered
    FAILED_WITHDRAWAL_EVENT // notification when withdrawal fails due to insufficient funds
}

// an enum is a special data type that represents a fixed set of constants
// allow us to define a set of named values that are logically related

// useful for categories, states, options that are unchanging