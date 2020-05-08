import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car("Volkswagen Golf", 200000);
        Car car2 = new Car("Toyota Corolla", 350000);
        Car car3 = new Car("Ford Escort", 175000);
        Car car4 = new Car("Toyota Corolla", 350000);
        Car car5 = new Car("Toyota Corolla", 100000);

        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        cars = cars.stream().distinct().collect(Collectors.toList());

        for (Car c : cars) {
            System.out.println(c.toString());
        }
    }
}
