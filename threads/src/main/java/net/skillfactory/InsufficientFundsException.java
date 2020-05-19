package net.skillfactory;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(Double money){
        super("Insufficient funds in the bank account. Amount to retire: " + money);
    }
}
