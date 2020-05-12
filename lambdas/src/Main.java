import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<Integer,Integer> function = number -> number%2;

        System.out.println(function.apply(5) + "\n");

    }
}
