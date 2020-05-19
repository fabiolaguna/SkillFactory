package net.skillfactory;

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

        System.out.println("Deposito: "+ deposit);
        bankAccount.deposit(deposit);   //O hacer un get de balance, modificarlo y hacer el set
        System.out.println("Balance de cuenta: " + bankAccount.getBalance());

        System.out.println("Retiro: "+ withdraw);
        try {
            bankAccount.withdraw(withdraw);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
        System.out.println("Balance de cuenta: " + bankAccount.getBalance());
    }
}
