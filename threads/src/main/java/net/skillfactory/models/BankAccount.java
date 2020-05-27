package net.skillfactory.models;

import net.skillfactory.exceptions.InsufficientFundsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private Double balance;
    private List<LocalDateTime> accountingDatesList;
    private boolean balanceAccountingAvailable = true;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        balance = 500000D;
        accountingDatesList = new ArrayList<>();
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

    public boolean isBalanceAccountingAvailable() {
        return balanceAccountingAvailable;
    }

    public synchronized boolean balanceAccounting() throws InterruptedException {

        if (accountingDatesList.size() <= 4){
            Thread.sleep(10000);
            System.out.println("El thread gerente " + Thread.currentThread().getName()
                    + " obtiene el balance de cuenta. Balance = " + getBalance() + "\n");
            accountingDatesList.add(LocalDateTime.now());
        }

        if (accountingDatesList.size() == 4){
            balanceAccountingAvailable = false;
        }

        notifyAll();
        return balanceAccountingAvailable;
    }

    public synchronized boolean deposit(Double money) throws InterruptedException {

        wait();
        setBalance(getBalance() + money);
        return balanceAccountingAvailable;
    }

    public synchronized boolean withdraw(Double money) throws InsufficientFundsException, InterruptedException {

        wait();
        if (money <= balance) {
            setBalance(getBalance() - money);
        } else {
            throw new InsufficientFundsException(money);
        }
        return balanceAccountingAvailable;
    }
}
