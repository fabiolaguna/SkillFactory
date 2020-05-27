package net.skillfactory.models;

import net.skillfactory.models.BankAccount;

public class BankManager implements Runnable {

    private String name;
    private String lastName;
    private BankAccount account;

    public BankManager(String name, String lastName, BankAccount account){
        this.name = name;
        this.lastName = lastName;
        this.account = account;
    }

    @Override
    public void run() {

        boolean keepRunning = true;
        while (keepRunning) {
            try {
                keepRunning = account.balanceAccounting();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
