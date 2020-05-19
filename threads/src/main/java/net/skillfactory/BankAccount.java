package net.skillfactory;

public class BankAccount {

    private String accountNumber;
    private Double balance;

    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized Double getBalance() {
        return balance;
    }

    public synchronized String getAccountNumber() {
        return accountNumber;
    }

    public synchronized void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public synchronized void setBalance(Double balance) {
        this.balance = balance;
    }

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        balance = 500000D;
    }

    public synchronized void deposit(Double money){
        setBalance(getBalance() + money);
    }

    public synchronized void withdraw(Double money) throws InsufficientFundsException {

        if (money <= balance) {
            setBalance(getBalance() - money);
        } else {
            throw new InsufficientFundsException(money);
        }
    }
}
