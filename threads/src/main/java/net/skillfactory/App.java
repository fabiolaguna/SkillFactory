package net.skillfactory;

import net.skillfactory.exceptions.TooHighNumberException;
import net.skillfactory.models.BankAccount;
import net.skillfactory.models.BankManager;
import net.skillfactory.models.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main( String[] args ) {

        BankAccount account = new BankAccount("12345");

        Thread t1 = new Thread(new Users("Fabio", "Laguna", account, 10000D, 125000D));
        Thread t2 = new Thread(new Users("Carlitos", "Tevez", account, 12000D, 200000D));
        Thread manager = new Thread(new BankManager("Argus", "Filch", account));

        t1.start();
        t2.start();
        manager.start();

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

        // Ejercicio 7

        // I create a Thread Pool but CompletableFuture gives one by default
        ExecutorService executor2 = Executors.newFixedThreadPool(2);

        CompletableFuture.runAsync(() -> System.out.println("I'm a useless CompletableFuture, only i'm printing this"), executor2);

        CompletableFuture<Double> completableDouble1 = CompletableFuture.supplyAsync(() -> Math.random() * 20, executor2);
        CompletableFuture<Double> completableDouble2 = CompletableFuture.supplyAsync(() -> Math.random() * 20, executor2);

        // Combining two CompletableFuture
        CompletableFuture<Double> additionResult = completableDouble1
                .thenCombine(completableDouble2, (number1, number2) -> number1 + number2)
                .thenApply(result -> { if (result > 30){
                                         throw new TooHighNumberException();
                                     }
                                     return result;
                })
                .handle((result, exception) -> { if (exception != null){   // Exception handling
                                                    System.out.println("An exception has occurred because the result is higher than 30. Returned 0");
                                                 }
                                                 result = 0D;
                                                 return result;
                });

        try {
            System.out.println(String.format("%.1f + %.1f = %.1f", completableDouble1.get(), completableDouble2.get(), additionResult.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor2.shutdown();
        try {
            executor2.awaitTermination(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ejercicio 8

        List<String> stringsList;
        stringsList = StringManagement.removeEvenLength(Arrays.asList("Hola", "Chau", "Que", "So", "Nos", "Vemos", "Fabio"));
        stringsList.stream().forEach(string -> System.out.println(string));

        StringManagement.printCharactersCount("Soy Independiente, aunque no gano la libertadores desde 1985, sigo siendo el máximo campeón con 7 copas");

        System.out.println(StringManagement.cesarEncryption("zfgZBnV"));

        System.out.println(StringManagement.reorderWords("Arriba la Birra"));

    }
}
