import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();

        orderNumbers(array, 3, 55, 12, 1, 33, 632, 2);
        System.out.println(array);

        orderNumbers(linked, 42, 3, 1, 14, 5);
        System.out.println(linked);
    }

    public static void orderNumbers(List<Integer> list, Integer ...numbers){

        list.addAll(Arrays.asList(numbers));
        Collections.sort(list);
    }
}
