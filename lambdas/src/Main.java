import com.sun.jmx.snmp.Timestamp;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Function<Integer,Integer> function = number -> number%2;
        System.out.println(function.apply(5) + "\n");

        Supplier<Timestamp> supplier = () -> new Timestamp(System.currentTimeMillis());
        System.out.println(supplier.get() + "\n");

    }
}
