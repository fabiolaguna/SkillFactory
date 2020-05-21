package net.skillfactory;

public class App {

    public static void main( String[] args ) {

        BankAccount account = new BankAccount("12345");

        Thread t1 = new Thread(new Users("Fabio", "Laguna", account, 10000D, 125000D));
        Thread t2 = new Thread(new Users("Carlitos", "Tevez", account, 12000D, 200000D));
        Thread manager = new Thread(new BankManager("Argus", "Filch", account));

        t1.start();
        t2.start();
        manager.start();
    }
}
