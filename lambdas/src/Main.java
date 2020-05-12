import com.sun.jmx.snmp.Timestamp;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Function<Integer,Integer> function = number -> number%2;
        System.out.println(function.apply(5) + "\n");

        Supplier<Timestamp> supplier = () -> new Timestamp(System.currentTimeMillis());
        System.out.println(supplier.get() + "\n");

        //Retorna el string mas grande
        BiFunction<String,String,String> strings = (word1, word2) -> word1.length()>word2.length() ? word1 : word2;
        System.out.println(strings.apply("Holanda", "Hola") + "\n");

        
    }
}
