package net.skillfactory.models;

import net.skillfactory.exceptions.InsufficientFundsException;
import net.skillfactory.models.BankAccount;

public class Users implements Runnable {

    private String name;
    private String lastName;
    private BankAccount bankAccount;
    private Double deposit;
    private Double withdraw;

    public Users(String name, String lastName, BankAccount bankAccount, Double deposit, Double withdraw) {
        this.name = name;
        this.lastName = lastName;
        this.bankAccount = bankAccount;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {

        boolean keepRunning = true;
        while (keepRunning) {
            try {
                keepRunning = bankAccount.deposit(deposit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El thread " + Thread.currentThread().getName() + " ha depositado: " + deposit
                    + ". Balance de cuenta: " + bankAccount.getBalance() + "\n");

            try {
                keepRunning = bankAccount.withdraw(withdraw);
            } catch (InsufficientFundsException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("El thread " + Thread.currentThread().getName() + " ha retirado: " + withdraw
                    + ". Balance de cuenta: " + bankAccount.getBalance() + "\n");
        }
    }
}
