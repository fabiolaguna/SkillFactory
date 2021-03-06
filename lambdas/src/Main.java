import com.sun.jmx.snmp.Timestamp;
import interfaces.IsolationMessage;
import interfaces.Multiplication;
import interfaces.PrintClass;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //EJERCICIO 1
        Function<Integer,Integer> function = number -> number%2;
        System.out.println(function.apply(5) + "\n");

        //EJERCICIO 2
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get() + "\n");

        //EJERCICIO 3
        //Retorna el string mas grande
        BiFunction<String,String,String> strings = (word1, word2) -> word1.length()>word2.length() ? word1 : word2;
        System.out.println(strings.apply("Holanda", "Hola") + "\n");

        //EJERCICIO 4
        Function<String,Integer> lengthVerification = string -> verifyString(string);
        System.out.println(lengthVerification.apply("1") + "\n");

        //EJERCICIO 5
        Map<Integer,String> stringMap = new HashMap<>();
        stringMap.put(1,"Boquita querido");
        stringMap.put(4,"Chau");
        stringMap.put(6,"Messi");
        stringMap.put(3,"Hola todo bien?");
        BiConsumer<Integer,String> printMap = (key,value) -> System.out.println("KEY: " + key + verifyAndPrintMapValue(value) + "\n");
        stringMap.forEach(printMap);

        //EJERCICIO 6
        PrintClass<Integer> classPrinter = obj -> System.out.println("Class: " + obj.getClass());
        classPrinter.getObjectClass(44);

        Multiplication<Double,Integer,Double> multiplication = (numb1, numb2) -> numb1 * numb2;
        System.out.println(multiplication.getMultiplication(2.5, 12));

        IsolationMessage message = () -> "No salimos mas deaa";
        System.out.println(message.getMessage());

        //EJERCICIO 7

        classPrinter(obj -> System.out.println("Class: " + obj.getClass()), "xd");
        System.out.println(multiplication(((num1, num2) -> num1*num2), 8.6, 4.1));
        System.out.println(isolationMessage(() -> "Stay at home bro"));
    }

    public static Integer verifyString(String s){

        if (s.length()>=1){
            return s.length();
        } else {
            throw new InsufficientLengthException();
        }
    }

    public static String verifyAndPrintMapValue(String value) {

        if (value.length() > 10) {
            return ("  VALUE: " + value);
        } else {
            return ("  VALUE: Value can't be printed. Not enough length");
        }
    }

    public static void classPrinter(PrintClass print, String string){
        print.getObjectClass(string);
    }

    public static Double multiplication (Multiplication<Double,Double,Double> mult, Double num1, Double num2){
        return mult.getMultiplication(num1, num2);
    }

    public static String isolationMessage(IsolationMessage message){
        return message.getMessage();
    }

}
