package net.skillfactory;

public class BankAccount {

    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        balance = 500000D;
    }

    public void deposit(Double money){
        balance += money;
    }

    public void withdraw(Double money) throws InsufficientFundsException {

        if (money <= balance) {
            balance -= money;
        } else {
            throw new InsufficientFundsException(money);
        }
    }
}
