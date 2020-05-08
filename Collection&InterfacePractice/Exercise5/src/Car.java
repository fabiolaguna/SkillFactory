import java.util.Objects;

public class Car {

    private String model;
    private Integer price;

    public Car(String model, Integer price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    @Override
    public String toString() {
        return "Model: " + model + "  -  Price: $" + price + "\n";
    }
}
