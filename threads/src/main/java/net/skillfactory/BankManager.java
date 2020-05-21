package net.skillfactory;

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

        System.out.println("El thread gerente " + Thread.currentThread().getName()
                + " obtiene el balance de cuenta. Balance = " + account.getBalance() + "\n");
    }
}
