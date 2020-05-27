package net.skillfactory;

import net.skillfactory.models.BankAccount;
import net.skillfactory.models.BankManager;
import net.skillfactory.models.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main( String[] args ) {

        /*BankAccount account = new BankAccount("12345");

        Thread t1 = new Thread(new Users("Fabio", "Laguna", account, 10000D, 125000D));
        Thread t2 = new Thread(new Users("Carlitos", "Tevez", account, 12000D, 200000D));
        Thread manager = new Thread(new BankManager("Argus", "Filch", account));

        t1.start();
        t2.start();
        manager.start();*/

        // Ejercicio 6

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable boca = () -> System.out.println("Runnable boca: Boca yo te amo, siempre te sigo a todos lados");
        Runnable river = () -> System.out.println("Runnable river: BBBB");
        Runnable newells = () -> System.out.println("Runnable newells: vamo ñubel");
        Callable<Integer> addition = () -> 10 + 15;
        Callable<String> greeting = () -> "Holanda todo bien?";

        executor.execute(boca);
        executor.execute(newells);
        executor.execute(river);

        Future<String> callableGreeting = executor.submit(greeting);
        Future<Integer> callableAddition = executor.submit(addition);

        while (!callableAddition.isDone()){
            System.out.println("Realizando suma");
        }

        try {
            System.out.println("El callable greeting te dice: " + callableGreeting.get());
            System.out.println("Resultado del callable addition: " + callableAddition.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Callable<String>> vowels = new ArrayList<>();
        vowels.add(() -> "Vowel 'a'");
        vowels.add(() -> "Vowel 'e'");
        vowels.add(() -> "Vowel 'i'");
        vowels.add(() -> "Vowel 'o'");
        vowels.add(() -> "Vowel 'u'");

        try {
            List<Future<String>> returnedVowels = executor.invokeAll(vowels); //O invokeAny para obtener el primer resultado
            for (Future<String> returnedVowel : returnedVowels){
                try {
                    System.out.println(returnedVowel.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        try {
            executor.awaitTermination(7L, TimeUnit.SECONDS); //Esperar las tareas incompletas
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
